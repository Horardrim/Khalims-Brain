package com.horadrim.khalims.brain.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import org.springframework.lang.NonNull;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ComponentAnnoBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private String beanName;

    private BeanFactory beanFactory;

    private ApplicationContext context;

    public ComponentAnnoBean() {

    }

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        log.info("bean factory: {}", this.beanFactory.getClass().getName());
    }

    @Override
    public void setBeanName(@NonNull String beanName) {
        this.beanName = beanName + " customer name";
        log.info("bean name: {}", this.beanName);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext context) {
        this.context = context;
        log.info("context: {}", this.context.getClass().getName());
    }

    public void perform() {
        log.info("do perform");
    }
}
