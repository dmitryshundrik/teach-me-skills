package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class ServicesAspect {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Pointcut("execution(public * org.example.CalculatorService.*(..))")
    public void calculatorServicePointcut() {
    }

    @Before("calculatorServicePointcut()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("some text...");
        logger.log(Level.INFO, joinPoint.toString());
    }
}
