package com.horadrim.khalims.brain.service;

import org.springframework.stereotype.Service;

@Service
public class AspectServiceImpl implements AspectService {
    public void handle() {
        System.out.print("calling handle method\n");
    }

    public void handleAround() {
        System.out.print("calling handleAround method\n");
    }
}
