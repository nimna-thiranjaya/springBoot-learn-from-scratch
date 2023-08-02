package com.nimna.orderService.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
