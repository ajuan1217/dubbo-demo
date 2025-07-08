package org.example.api.def;

import org.example.api.model.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(String name);
    List<OrderDto> getOrders();
}
