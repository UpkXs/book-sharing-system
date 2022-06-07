package kz.iitu.itse1903.sugurali.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MessageReceiver {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    MessageConverter messageConverter;

    public String receiveMeassage() {
        try {
            Message message = jmsTemplate.receive();
            String response = (String) messageConverter.fromMessage(message);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}