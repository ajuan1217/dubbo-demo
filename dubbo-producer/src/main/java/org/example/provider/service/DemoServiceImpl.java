package org.example.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.api.def.DemoService;
import org.example.api.model.User;

@DubboService(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Dubbo 3.3 with Spring Boot 3.2)";
    }

    @Override
    public User getUser(Long id) {
        return new User(id, "User" + id, 20 + id.intValue() % 10);
    }
}
