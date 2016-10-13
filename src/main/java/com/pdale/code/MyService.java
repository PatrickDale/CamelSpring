package com.pdale.code;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MyService {

    private ProducerTemplate producerTemplate;

    @Autowired
    public MyService(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    void sendObjectsToQueue() {
        for (int i = 0; i < 10; i++){
            producerTemplate.sendBody("test-jms:queue:test.queueme", "Test Message " + i);
        }
    }

    public void queueName(String name) {
        producerTemplate.sendBody("test-jms:queue:name.queue", "Hello " + name);
    }
}
