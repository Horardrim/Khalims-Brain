package com.horadrim.khalims.brain.service.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PointCutAspectServiceImpl implements AspectService {
    public void handle() {
        log.info("calling PointCutAspectServiceImpl.handle method");
    }

    public void handleAround() {
        log.info("calling PointCutAspectServiceImpl.handleAround method");
    }
}
