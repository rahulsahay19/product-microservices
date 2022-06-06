package com.microservices.myview.order.controller;

import com.microservices.myview.order.client.InventoryClient;
import com.microservices.myview.order.dto.OrderDto;
import com.microservices.myview.order.model.Order;
import com.microservices.myview.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto){
        boolean allProductsInStock = orderDto.getOrderLineItemsList().stream().allMatch(orderLineItems -> inventoryClient.checkStock(orderLineItems.getSkuCode()));
        if(allProductsInStock){
            Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());
            orderRepository.save(order);
            return "Order saved successfully";
        }else{
            return "Order not in stock";
        }

    }
}
