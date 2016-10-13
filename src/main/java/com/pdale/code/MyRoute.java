package com.pdale.code;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("test-jms:queue:test.queueme").to("file://test");

        from("test-jms:queue:name.queue").to("http://localhost:8080/");
    }
}
