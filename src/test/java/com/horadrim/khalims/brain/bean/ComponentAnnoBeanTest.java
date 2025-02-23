package com.horadrim.khalims.brain.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ComponentAnnoBeanTest {

    @Autowired
    private ComponentAnnoBean testComponentAnnoBean;

    @Test
    public void normalTest() {
        testComponentAnnoBean.perform();
        log.info("test");
    }
}
