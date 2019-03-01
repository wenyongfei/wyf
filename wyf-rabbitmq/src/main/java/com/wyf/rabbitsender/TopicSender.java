package com.wyf.rabbitsender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * topic 是RabbitMQ中最灵活的一种方式，可以根据binding_key自由的绑定不同的队列
     首先对topic规则配置，这里使用两个队列来测试（也就是在Application类中创建和绑定的topic.message和topic.messages两个队列），
     其中topic.message的bindting_key为“topic.message”完全匹配，topic.messages的binding_key为“topic.#”模糊匹配；
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg1 = "I am topic.mesaage msg======";
        System.out.println("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2 = "I am topic.mesaages msg########";
        System.out.println("sender2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

}
