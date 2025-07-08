package org.example.first.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.api.first.CustomerService;

@DubboService(group = "${ENV_GROUP:PROD_GROUP}-foreign-customer", version = "1.0.0")
public class ForeignCustomerServiceImpl implements CustomerService {

    @Override
    public String getCustomerName() {
        return "An international customer friend.";
    }
}
