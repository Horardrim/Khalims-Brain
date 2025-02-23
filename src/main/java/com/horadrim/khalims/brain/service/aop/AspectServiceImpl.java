package com.horadrim.khalims.brain.service.aop;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AspectServiceImpl implements AspectService {
    public void handle() {
        log.info("calling handle method");
    }

    public void handleAround() {
        log.info("calling handleAround method\n");
    }
}
