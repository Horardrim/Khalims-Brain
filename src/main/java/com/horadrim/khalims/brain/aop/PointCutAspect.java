package com.horadrim.khalims.brain.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointCutAspect {
    @Pointcut("execution(public void com.horadrim.khalims.brain.service.PointCutAspectServiceImpl.handle())")
    public void pointCutBefore() {
        System.out.print("calling pointCutBefore\n");
    }

    @Before(value = "PointCut")
    public void before() {
        System.out.print("calling before\n");
    }
}
