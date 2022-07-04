package com.wry.consume;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1> 消费消息 <h1>
 *
 * @author 魏如元
 * @since 2022/7/1
 */
@Service
public class ConsumerService {

    public void consumerMessage() throws Exception{
        // 实例化消费者
        final DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("wry-producers");
        // nameServer 地址
        consumer.setNamesrvAddr("47.99.48.23:9876");
        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("borker-w", "*");
        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                System.out.printf("%s 接收到的消息: %s %n", Thread.currentThread().getName(), msgs);
                System.out.println("msgs:"+msgs);
                // 标记该消息已经被成功消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 启动消费者实例
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }

}
