package com.luomo.study.activemq.service;

import javax.jms.Destination;

/**
 * Created by LiuMei on 2017-09-07.
 */
public interface ProducerService {

    /**
     * 发送纯文本消息
     * @param destination
     * @param message
     */
    void sendMessage(Destination destination, String message);

}
