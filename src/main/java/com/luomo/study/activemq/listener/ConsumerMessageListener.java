package com.luomo.study.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by LiuMei on 2017-09-07.
 */
public class ConsumerMessageListener implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        System.out.println("=========收到一条纯文本消息========");
        try {
            System.out.println("==消息内容=="+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
