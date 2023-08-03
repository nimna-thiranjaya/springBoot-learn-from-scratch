package com.nimna.orderService.dto.request;

import com.nimna.orderService.model.OrderLineItems;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class OrderRequest {
    private List<OrderLineItemsDTO> orderLineItems;
}
