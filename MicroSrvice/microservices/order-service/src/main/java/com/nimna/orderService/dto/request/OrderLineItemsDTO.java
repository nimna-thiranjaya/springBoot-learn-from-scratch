package com.nimna.orderService.dto.request;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class OrderLineItemsDTO {
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
