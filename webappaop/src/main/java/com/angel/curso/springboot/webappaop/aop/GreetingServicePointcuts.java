package com.angel.curso.springboot.webappaop.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

    @Pointcut("execution(* com.angel.curso.springboot.webappaop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut() {

    }

    @Pointcut("execution(* com.angel.curso.springboot.webappaop.services.GreetingService.*(..))")
    public void greetingOrderLoggerPointCut() {

    }

}
