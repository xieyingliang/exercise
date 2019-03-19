package com.hp.xyl.mq.service;

/**
 * Author:xyl
 * Date:2019/3/14 16:20
 * Description:
 */
public interface ConsumerService {
    void receiveMsg(String msg);

    void subMsg(String msg);
}
