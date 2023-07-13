package com.nimna.possystemlts.dto.response;

import com.nimna.possystemlts.dto.request.OrderDetailsSaveRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResponseOrderDetailsDTO {
    //Customer
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;

    //order
    private double total;

    private Date orderDate;

}
