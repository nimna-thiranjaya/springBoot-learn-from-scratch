package com.nimna.possystemlts.dto.request;

import com.nimna.possystemlts.entity.Item;
import com.nimna.possystemlts.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailsSaveRequest {

    private String itemName;

    private double quantity;

    private double amount;

    private int items;

    private int orders;
}
