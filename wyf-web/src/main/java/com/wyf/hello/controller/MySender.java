package com.wyf.hello.controller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author wenyf
 * @date 2019/2/16 0016
 */
@Component
public class MySender {
    // 定义一个消息队列的名字用于测试使用
    final static String queueName = "spring-boot";

    // 创建Queue
    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    // 定义一个topic交换器
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }

    // 将消息队列queue和exchange绑定
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(queueName);
    }

    // 创建消息监听的容器
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MyReciver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
