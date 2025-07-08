package org.example.second.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.api.second.SecondService;

@DubboService(version = "1.0.0")
public class SecondServiceImpl implements SecondService {
    @Override
    public String sayHello(String name) {

        if("fastfail".equals(name)) {
            throw new RuntimeException("testing fast fail");
        }
        return "The second producer say Hello to you: " + name;
    }
}
