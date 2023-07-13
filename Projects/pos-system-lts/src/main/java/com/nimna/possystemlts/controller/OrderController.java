package com.nimna.possystemlts.controller;

import com.nimna.possystemlts.dto.paginated.PaginatedResponseOrderDetails;
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

    @GetMapping(
            params = {"stateType", "page", "size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getOrderDetails (
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {

        PaginatedResponseOrderDetails p = null;

        if (stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;

            p = orderService.getAllOrderDetails(status, page, size);
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", p),
                HttpStatus.OK
        );
    }
}
