package com;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {

    // Перехватываем все методы DAO
    @Around("execution(* com.delivery.dao.*.*(..))")
    public Object logDAO(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("🔥 ASPECT WORKING 🔥");

        String methodName = joinPoint.getSignature().toShortString();

        System.out.println("========== LOG START ==========");
        System.out.println("Метод: " + methodName);

        long start = System.currentTimeMillis();

        try {

            Object result = joinPoint.proceed();

            long time = System.currentTimeMillis() - start;

            System.out.println("Успешное выполнение");
            System.out.println("Время: " + time + " ms");
            System.out.println("=========== LOG END ===========");

            return result;

        } catch (Exception e) {

            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("=========== LOG END ===========");

            throw e;
        }

    }
}