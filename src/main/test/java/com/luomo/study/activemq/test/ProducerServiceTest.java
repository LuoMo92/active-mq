package com.luomo.study.activemq.test;

import com.luomo.study.activemq.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by LiuMei on 2017-09-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProducerServiceTest {

    @Autowired
    private ProducerService producerService;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Autowired
    @Qualifier("sessionAwareQueue")
    private Destination sessionDestination;

    @Test
    public void testSend(){
        for (int i=0;i<3;i++){
            producerService.sendMessage(destination,"哈哈哈"+i);
        }
    }

    @Test
    public void testSessionSend(){
        for (int i=0;i<3;i++){
            producerService.sendMessage(sessionDestination,"哈哈哈"+i);
        }
    }
}
