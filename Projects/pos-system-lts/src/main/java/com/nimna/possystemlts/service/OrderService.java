package com.nimna.possystemlts.service;

import com.nimna.possystemlts.dto.paginated.PaginatedResponseOrderDetails;
import com.nimna.possystemlts.dto.request.OrderSaveRequestDTO;

public interface OrderService {
    public String createOrder(OrderSaveRequestDTO orderSaveRequestDTO);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
