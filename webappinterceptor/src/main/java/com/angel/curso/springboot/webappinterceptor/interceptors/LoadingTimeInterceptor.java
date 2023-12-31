package com.angel.curso.springboot.webappinterceptor.interceptors;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;
import java.util.*;

@Component
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = ( (HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor: preHandle() entrando... " + controller.getMethod().getName() );

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);

        //  codigo para generar un ligero delay
        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

        /*
            codigo de fallo

            Map<String, String> json = new HashMap<>();
            json.put("error", "No tienes acceso a esta pagina");
            json.put("date", new Date().toString());

            ObjectMapper mapper = new ObjectMapper();
            String cadenaJson = mapper.writeValueAsString(json);
            response.setContentType("application/json");
            response.setStatus(401);
            response.getWriter().write(cadenaJson);

            return false;
         */

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        HandlerMethod controller = ( (HandlerMethod) handler);
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;

        logger.info("Tiempo transcurrido: " + result + " milisegundos");
        logger.info("LoadingTimeInterceptor: postHandle() saliendo... " + controller.getMethod().getName());
    }
}
