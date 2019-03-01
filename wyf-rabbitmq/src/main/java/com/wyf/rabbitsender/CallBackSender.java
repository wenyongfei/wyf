package com.wyf.rabbitsender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 增加回调处理，这里不再使用application.properties默认配置的方式，会在程序中显示的使用文件中的配置信息。
 * 该示例中没有新建队列和exchange，用的是第5节中的topic.messages队列和exchange转发器。消费者也是第5节中的topicMessagesReceiver
 */
@Component
public class CallBackSender implements  RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate rabbitTemplatenew;

    public void send() {

        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        System.out.println(msg );
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);
    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // TODO Auto-generated method stub
        System.out.println("callbakck confirm: " + correlationData.getId());
    }

}
