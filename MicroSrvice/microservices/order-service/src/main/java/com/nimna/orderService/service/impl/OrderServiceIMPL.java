package com.nimna.orderService.service.impl;

import com.nimna.orderService.dto.request.OrderLineItemsDTO;
import com.nimna.orderService.dto.request.OrderRequest;
import com.nimna.orderService.model.Order;
import com.nimna.orderService.model.OrderLineItems;
import com.nimna.orderService.repository.OrderRepository;
import com.nimna.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItems().stream().map(orderLineItemsDTO -> mapToDto(orderLineItemsDTO)).toList();

        order.setOrderLineItems(orderLineItems);

        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDTO.getId());
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setSkuCode((orderLineItemsDTO.getSkuCode()));
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());

        return orderLineItems;
    }
}
