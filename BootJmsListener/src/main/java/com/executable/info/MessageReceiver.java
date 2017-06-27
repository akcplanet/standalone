package com.executable.info;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

import javax.jms.JMSException;

/**
 * Created by 
 */
@Component
public class MessageReceiver {

    @JmsListener(destination = MyConfig.COMMENT_QUEUE)
    public void receiveMessage(final Message<String> message) throws JMSException {
        String response = message.getPayload();
        System.out.print(response);
    }
}
