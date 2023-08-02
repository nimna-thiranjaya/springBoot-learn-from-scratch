package com.nimna.producatService.dto.request;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ProductRequest {
    private String name;
    private String description;
    private String productImage;
    private BigDecimal price;
}
