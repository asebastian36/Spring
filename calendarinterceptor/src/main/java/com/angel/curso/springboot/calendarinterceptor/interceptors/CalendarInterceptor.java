package com.angel.curso.springboot.calendarinterceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.*;
import java.util.*;

@Component("calendarInterceptor")
public class CalendarInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private Integer open;

    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= open && hour < close) {
            StringBuilder message = new StringBuilder("Bienvenidos al horario de atencion a clientes, ");
            message.append("atendemos desde las ");
            message.append(open);
            message.append("hrs");
            message.append(" hasta las ");
            message.append(close);
            message.append("hrs, ");
            message.append("Gracias por su visita");
            request.setAttribute("message", message.toString());
            request.setAttribute("hour", hour);
            return true;
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();

        StringBuilder message = new StringBuilder("Cerrado, fuera del horario de atencion, ");
        message.append("visitenos desde las ");
        message.append(open);
        message.append("hrs");
        message.append(" hasta las ");
        message.append(close);
        message.append("hrs, ");
        message.append("Gracias por su visita");

        data.put("message", message.toString());
        data.put("date", new Date());

        response.setContentType("application/json");
        response.setStatus(400);
        response.getWriter().write(mapper.writeValueAsString(data));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
