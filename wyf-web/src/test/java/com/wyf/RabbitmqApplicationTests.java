package com.wyf;

import static org.junit.Assert.assertTrue;

import com.wyf.hello.WebApplicationClient;
import com.wyf.hello.controller.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplicationClient.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class RabbitmqApplicationTests {
//    @Autowired
//    private HelloSender helloSender;
//
//    @Test
//    public void hello() throws Exception {
//        helloSender.send();
//    }
}