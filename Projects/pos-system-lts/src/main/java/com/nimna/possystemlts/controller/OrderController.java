package com.nimna.possystemlts.controller;

import com.nimna.possystemlts.dto.request.OrderSaveRequestDTO;
import com.nimna.possystemlts.service.OrderService;
import com.nimna.possystemlts.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveRequestDTO orderSaveRequestDTO) {

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", orderService.createOrder(orderSaveRequestDTO)),
                HttpStatus.CREATED
        );
    }
}
