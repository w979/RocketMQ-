package com.wry.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Service;

/**
 * <h1> 单向发送消息 <h1>
 *
 * 这种方式主要用在不特别关心发送结果的场景，例如日志发送。
 *
 * @author 魏如元
 * @since 2022/7/1
 */
@Service
public class OnewayProducer {

    public void onewaySend() throws Exception{
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("OnewayProducer_Group");
        // 设置NameServer的地址
        producer.setNamesrvAddr("47.99.48.23:9876");
        // 启动Producer实例
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("broker-a","log",("日志-"+i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送单向消息，没有任何返回结果
            producer.sendOneway(msg);

        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }

}
