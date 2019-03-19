package com.hp.xyl.mq.service.impl;

import com.hp.xyl.mq.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;


/**
 * Author:xyl
 * Date:2019/3/14 16:15
 * Description:
 */
@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void sendMessage(String name, String message) {
        log.info("=========>send Queue message : " + message);
        Destination destination = new ActiveMQQueue(name);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @Override
    public void sendPubMessage(String name, String msg) {
        log.info("=========>send Queue message : " + msg);
        Destination destination = new ActiveMQTopic(name);
        jmsMessagingTemplate.convertAndSend(destination, msg);
    }
}
