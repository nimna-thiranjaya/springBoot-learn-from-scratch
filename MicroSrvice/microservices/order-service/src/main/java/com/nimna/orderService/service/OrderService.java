package com.nimna.orderService.service;

import com.nimna.orderService.dto.request.OrderRequest;

public interface OrderService {
    public void placeOrder(OrderRequest orderRequest);
}
