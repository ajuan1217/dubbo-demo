package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.api.def.OrderService;
import org.example.api.model.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @DubboReference(version = "1.0.0")
    private OrderService orderService;

    @GetMapping("/order/create/{name}")
    public OrderDto getUser(@PathVariable String name) {
        return orderService.createOrder(name);
    }

    @GetMapping("/orders")
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

}
