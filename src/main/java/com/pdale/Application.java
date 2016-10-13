package com.pdale;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
public class Application {

    @Bean(name = "jmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> providesJmsFactory() {
        return new DefaultJmsListenerContainerFactory();
    }

    @Bean(name = "test-jms")
    public JmsComponent providesJmsComponent() {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
        return JmsComponent.jmsComponentAutoAcknowledge(connectionFactory);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
