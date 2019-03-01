package com.wyf.hello;

import com.wyf.hello.controller.HelloSender;
import org.junit.After;
import org.junit.Test;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;


/**
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource(locations = {"classpath:spring/application*.xml"})
public class WebApplicationClient {
//    @Autowired
//    private HelloSender helloSender;

//    @Bean
//    public Queue Queue() {
//        return new Queue("hello");
//    }

    public static void main( String[] args ){
        SpringApplication.run(WebApplicationClient.class, args);
    }

//    @After
//    public void hello() throws Exception {
//        helloSender.send();
//    }
}

