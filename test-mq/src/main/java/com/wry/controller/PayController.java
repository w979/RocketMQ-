package com.wry.controller;

import com.wry.consume.ConsumerService;
import com.wry.producer.AsyncProducer;
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
public class PayController {

    @Resource
    private AsyncProducer asyncProducer;
    @Resource
    private SyncProducer syncProducer;
    @Resource
    private ConsumerService consumerService;


    /**
     * 发送同步消息
     */
    @GetMapping("syncSend")
    public String producers() throws Exception {
       // asyncProducer.asyncSend();
        syncProducer.syncSend();
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
