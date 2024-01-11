package com.angel.curso.springboot.webappaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.*;

@Aspect
@Order(1)
@Component
public class GreetingOrderAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("GreetingServicePointcuts.greetingOrderLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Before: " + method + " invocado con los sig args: " + args);
    }

    @After("GreetingServicePointcuts.greetingOrderLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("After: " + method + " invocado con los sig args: " + args);
    }
}
