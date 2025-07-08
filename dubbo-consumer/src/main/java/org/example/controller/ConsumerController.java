package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.api.def.DemoService;
import org.example.api.first.CustomerService;
import org.example.api.first.FirstService;
import org.example.api.model.User;
import org.example.api.second.SecondService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @DubboReference(version = "1.0.0")
    private DemoService demoService;

    @DubboReference
    private FirstService firstService;

    @DubboReference
    private SecondService secondService;

    @DubboReference(group = "${ENV_GROUP:PROD_GROUP}-foreign-customer")
    private CustomerService customerService;

    @GetMapping("/hello/{name}") //http://localhost:8082/hello/Lily
    public String sayHello(@PathVariable String name) {
        return demoService.sayHello(name)
                + "\t" + firstService.sayHello(name)
                + "\t" + secondService.sayHello(name)
                + "\t" + customerService.getCustomerName()
                ;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return demoService.getUser(id);
    }
}
