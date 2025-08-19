package com.horadrim.khalims.brain.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.ContextConfiguration;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentAnnoBean.class)
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
