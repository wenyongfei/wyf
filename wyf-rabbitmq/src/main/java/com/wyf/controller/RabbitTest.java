package com.wyf.controller;

import com.wyf.rabbitsender.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;
    @Autowired
    private UserSender userSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private CallBackSender callBackSender;

    @ApiOperation(value="发送测试消息队列", notes="addEntity")
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public void hello() {
        helloSender1.send("hello1");
    }

    /**
     * 单生产者-多消费者
     */
    @PostMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+ i);
        }
    }
    /**
     * 单生产者-多消费者
     */
    @PostMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+ i);
            helloSender2.send("hellomsg:"+ i);
        }
    }

    /**
     * 实体类传输测试
     */
    @PostMapping("/userTest")
    public void userTest() {
        userSender.send();
    }
    /**
     * topic exchange类型rabbitmq测试
     */
    @PostMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }
    /**
     * fanout exchange类型rabbitmq测试
     */
    @PostMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    /**
     * 带callback的消息发送
     */
    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }

}
