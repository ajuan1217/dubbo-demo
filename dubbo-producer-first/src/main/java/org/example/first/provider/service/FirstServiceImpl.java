package org.example.first.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.api.first.FirstService;
import org.example.first.provider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(version = "1.0.0", methods = {
//        @Method(name = "createOrder", parameters = {"cluster", "failfast"})
})
public class FirstServiceImpl implements FirstService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String sayHello(String name) {

        if("fastfail".equals(name)) {
            throw new RuntimeException("testing fast fail");
        }
        return "The first producer say Hello to you: " + name;
    }
}
