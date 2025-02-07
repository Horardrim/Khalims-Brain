package com.horadrim.khalims.brain.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.horadrim.khalims.brain.service.AspectService;
import com.horadrim.khalims.brain.service.PointCutAspectServiceImpl;

@RestController
public class AspectController {

    @Autowired
    private AspectService aspectService;

    @RequestMapping("/aspect")
    public String aspect() {
        aspectService.handle();
        aspectService.handleAround();

        AspectService temp = new PointCutAspectServiceImpl();
        temp.handle();
        return "spring boot aspect module";
    }
}
