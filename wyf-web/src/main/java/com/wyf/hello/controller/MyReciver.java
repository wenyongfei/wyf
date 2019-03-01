package com.wyf.hello.controller;

import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

@Component
public class MyReciver {
    /*  自动注入CountDownLatch类告诉发送者消息已经收到了即用来act时候使用
        不需要在应用程序中具体实现它，只需要latch.countDown()就行了
     */
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("TestRecive： <" + message + ">");
        latch.countDown();
    }
    public CountDownLatch getLatch() {
        return latch;
    }
}
