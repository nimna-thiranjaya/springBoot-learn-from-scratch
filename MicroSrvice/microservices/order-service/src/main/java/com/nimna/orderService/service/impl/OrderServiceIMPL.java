package com.nimna.orderService.service.impl;

import com.nimna.orderService.dto.request.OrderLineItemsDTO;
import com.nimna.orderService.dto.request.OrderRequest;
import com.nimna.orderService.model.Order;
import com.nimna.orderService.model.OrderLineItems;
import com.nimna.orderService.repository.OrderRepository;
import com.nimna.orderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    private final WebClient webClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItems().stream().map(orderLineItemsDTO -> mapToDto(orderLineItemsDTO)).toList();

        order.setOrderLineItems(orderLineItems);

        //call inventory service and place order if order is exist
        Boolean result = webClient.get()
                .uri("http://localhost:8082/api/v1/inventory")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();

        if(result){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in stoke, please try again later");
        }


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
