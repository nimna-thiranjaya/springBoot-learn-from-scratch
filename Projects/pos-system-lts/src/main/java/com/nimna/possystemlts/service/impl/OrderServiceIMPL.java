package com.nimna.possystemlts.service.impl;

import com.nimna.possystemlts.dto.request.OrderSaveRequestDTO;
import com.nimna.possystemlts.entity.Order;
import com.nimna.possystemlts.entity.OrderDetails;
import com.nimna.possystemlts.repository.CustomerRepo;
import com.nimna.possystemlts.repository.ItemRepo;
import com.nimna.possystemlts.repository.OrderDetailsRepo;
import com.nimna.possystemlts.repository.OrderRepo;
import com.nimna.possystemlts.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String createOrder(OrderSaveRequestDTO orderSaveRequestDTO) {
        Order order = new Order(
                orderSaveRequestDTO.getTotal(),
                orderSaveRequestDTO.getOrderDate(),
                customerRepo.getReferenceById(orderSaveRequestDTO.getCustomers())
        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetails = modelMapper.map(orderSaveRequestDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>() {
            }.getType());

            for (int i=0; i < orderDetails.size(); i++){
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getReferenceById(orderSaveRequestDTO.getOrderDetails().get(i).getItems()));
            }

            if(orderDetails.size() > 0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "Order Saved!";
        }
        return null;
    }
}
