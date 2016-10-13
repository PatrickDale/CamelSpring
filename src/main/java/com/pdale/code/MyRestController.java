package com.pdale.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyRestController {

    private MyService myService;

    @Autowired
    public MyRestController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void pushToQueue() {
        myService.sendObjectsToQueue();
    }

    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public void queueMyName(@PathVariable String name) {
        myService.queueName(name);
    }
}
