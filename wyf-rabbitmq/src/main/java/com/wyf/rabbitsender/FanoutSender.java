package com.wyf.rabbitsender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息。
 * 这里使用三个队列来测试（也就是在Application类中创建和绑定的fanout.A、fanout.B、fanout.C）这三个队列都和Application中创建的fanoutExchange转发器绑定。
 *
 * 就算fanoutSender发送消息的时候，指定了routing_key为"abcd.ee"，但是所有接收者都接受到了消息
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello i am hzb";
        System.out.println(msgString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
    }

}
