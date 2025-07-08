package org.example.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.api.def.OrderService;
import org.example.api.model.OrderDto;
import org.example.provider.entity.OrderEntity;
import org.example.provider.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@DubboService(version = "1.0.0", methods = {
//        @Method(name = "createOrder", parameters = {"cluster", "failfast"})
})
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(String name) {

        if("fastfail".equals(name)) {
            throw new RuntimeException("testing fast fail");
        }
        OrderEntity entity = OrderEntity.builder()
                .name(name)
                .orderNo(UUID.randomUUID().toString())
                .createdAt(new Timestamp(new Date().getTime()))
                .build();
        OrderEntity ent = orderRepository.save(entity);

        return OrderDto.builder().name(name).orderNo(ent.getOrderNo()).createdAt(ent.getCreatedAt()).build();
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderEntity> all = orderRepository.findAll();
        List<OrderDto> res = all.stream().map(ent -> OrderDto.builder().name(ent.getName()).orderNo(ent.getOrderNo()).createdAt(ent.getCreatedAt()).build()).collect(Collectors.toList());
        return res;
    }
}
