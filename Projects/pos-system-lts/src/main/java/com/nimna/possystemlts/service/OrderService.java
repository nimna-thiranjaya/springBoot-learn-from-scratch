package com.nimna.possystemlts.service;

import com.nimna.possystemlts.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    public String createOrder(OrderSaveRequestDTO orderSaveRequestDTO);
}
