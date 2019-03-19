package com.hp.xyl.mq.service;

/**
 * Author:xyl
 * Date:2019/3/14 16:14
 * Description:消息生产者service
 */
public interface ProducerService {
    /**
     * @param name
     * @param message
     */
    void sendMessage(String name, String message);

    void sendPubMessage(String name, String msg);
}
