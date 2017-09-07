package com.luomo.study.activemq.service.impl;

import com.luomo.study.activemq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


/**
 * Created by LiuMei on 2017-09-07.
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, final String message) {
        System.out.println("=========生产者发送消息========");
        System.out.println("==消息内容=="+message);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
