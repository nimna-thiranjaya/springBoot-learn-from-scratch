package com.nimna.possystemlts.dto.request;

import com.nimna.possystemlts.entity.Customer;
import com.nimna.possystemlts.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderSaveRequestDTO {


    private double total;
    private int customers;
    private Date orderDate;
    private List<OrderDetailsSaveRequest> orderDetails;
}
