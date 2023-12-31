package com.angel.curso.springboot.webappinterceptor;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);

        //  en ambas opciones se pueden usar strings o listas

        //  se puede elegir en que rutas funciona con .addPathPatterns
        //  o se puede elegir a todos y excluir algunos con .excludePathPatterns

        //  ejemplo de ruta: /app/extra
    }
}
