package com.angel.curso.springboot.webappaop.aop;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.*;

@Aspect
@Order(2)
@Component
public class GreetingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    String name = "[GreetingAspect]";

    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info(name.concat("Before: " + method + " con los argumentos " + args));
    }

    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info(name.concat("After Throwing: " + method + " con los argumentos " + args));
    }

    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info(name.concat("After Returning: " + method + " con los argumentos " + args));
    }

    @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info(name.concat("After: " + method + " con los argumentos " + args));
    }

    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint proceeding) throws Throwable {
        String method = proceeding.getSignature().getName();
        String args = Arrays.toString(proceeding.getArgs());
        Object result = null;

        try {
            logger.info(name.concat("El metodo " + method + "() " + "con los parametros " + args));
            result = proceeding.proceed();
            logger.info(name.concat("El retorno del metodo es: " + result));
            return result;
        } catch (Throwable e) {
            logger.error(name.concat("Error en la llamada del metodo " + method + "()"));
            throw e;
        }
    }
}
