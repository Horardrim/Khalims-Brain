package com.horadrim.khalims.brain.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAspect {
    @Before("execution(public void com.horadrim.khalims.brain.service.AspectService.handle())")
    public void beforeMethodExecution() {
        System.out.print("before calling method with execution statement\n");
    }

    @Around("execution(public void com.horadrim.khalims.brain.service.AspectService.handleAround())")
    public void roundMethodExecution(ProceedingJoinPoint pjp) throws Throwable {
        System.out.print("around calling method with execution statement\n");
        pjp.proceed();
    }
}
