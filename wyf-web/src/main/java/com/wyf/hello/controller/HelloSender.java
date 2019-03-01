package com.wyf.hello.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

//创建一个生产者
@RestController
@Api(description = "testRabbitMq", tags = "rabbit-system")
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @ApiOperation(value="发送测试消息队列", notes="addEntity")
//    @RequestMapping(value = "/send",method = RequestMethod.POST)
    @PostMapping("send")
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("helloQueue", context);
    }

    @ApiOperation(value="发送Topic测试", notes="测试")
    @RequestMapping(value = "/sendTopic",method = RequestMethod.POST)
    public void sendTopic() {
        String msg1 = "I am topic.mesaage msg===1===";
        System.out.println("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2 = "I am topic.mesaages msg####2####";
        System.out.println("sender2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

    @ApiOperation(value="测试A", notes="测试")
    @RequestMapping(value = "/testA",method = RequestMethod.POST)
    public void testA(){
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend("spring-boot", "Hello from RabbitMQ!");
    }
}
