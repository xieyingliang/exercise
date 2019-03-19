package com.hp.xyl.mq.service.impl;

import com.hp.xyl.mq.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * Author:xyl
 * Date:2019/3/14 16:23
 * Description:
 */
@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {
    @JmsListener(destination = "queueMsg")
    @Override
    public void receiveMsg(String msg) {
        log.info("received message === " + msg);
    }

    @JmsListener(destination = "pub_sub",containerFactory="jmsListenerContainerTopic")
    @Override
    public void subMsg(String msg) {
        log.info("received message === " + msg);
    }
}
