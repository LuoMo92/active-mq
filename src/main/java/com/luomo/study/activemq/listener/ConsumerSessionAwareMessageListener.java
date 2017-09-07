package com.luomo.study.activemq.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created by LiuMei on 2017-09-07.
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<TextMessage> {

    private Destination destination;

    public void onMessage(TextMessage textMessage, Session session) throws JMSException {
        System.out.println("=======收到消息======");
        System.out.println("==消息内容=="+textMessage.getText());
        MessageProducer producer = session.createProducer(destination);
        TextMessage textMessage1 = session.createTextMessage("======session======");
        producer.send(textMessage1);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
