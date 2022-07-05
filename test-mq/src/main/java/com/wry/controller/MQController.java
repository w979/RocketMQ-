package com.wry.controller;

import com.wry.consume.ConsumerService;
import com.wry.producer.AsyncProducer;
import com.wry.producer.OnewayProducer;
import com.wry.producer.SortProducer;
import com.wry.producer.SyncProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * <h1>  <h1>
 *
 * @author 魏如元
 * @since 2022/6/8
 */
@RestController
@RequestMapping("mq")
@Slf4j
public class MQController {

    @Resource
    private AsyncProducer asyncProducer;
    @Resource
    private SyncProducer syncProducer;
    @Resource
    private ConsumerService consumerService;
    @Resource
    private OnewayProducer onewayProducer;
    @Resource
    private SortProducer sortProducer;


    /**
     * 发送同步消息
     */
    @GetMapping("send")
    public String producers() throws Exception {
        //异步消息
        //asyncProducer.asyncSend();
        //同步消息
        // syncProducer.syncSend();
        //单向消息
        //onewayProducer.onewaySend();
        //顺序消息
        sortProducer.sortProducer();
        return "ok";
    }

    /**
     * 消费信息
     */
    @GetMapping("consumer1")
    public String consumer() throws Exception {
        consumerService.consumerMessage();
        return "ok";
    }

}
