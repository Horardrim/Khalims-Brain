package com.horadrim.khalims.brain.service;

public class PointCutAspectServiceImpl implements AspectService {
    public void handle() {
        System.out.print("calling PointCutAspectServiceImpl.handle method\n");
    }

    public void handleAround() {
        System.out.print("calling PointCutAspectServiceImpl.handleAround method\n");
    }
}
