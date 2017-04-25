package com.ymPrac.statemachine.spring;

import com.ymPrac.statemachine.spring.simpleDemo.Events;
import com.ymPrac.statemachine.spring.simpleDemo.States;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import javax.annotation.Resource;

/**
 * 启动类
 * Created by Yan Meng on 2016/9/21.
 */
//@Configuration  //配置控制
//@EnableAutoConfiguration    //启用自动配置
//@ComponentScan  //组件扫描
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App implements CommandLineRunner {

    @Resource
    private StateMachine<States, Events> stateMachine;

    //启动Spring Boot项目的唯一入口
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.E1);
        stateMachine.sendEvent(Events.E2);
    }
}
