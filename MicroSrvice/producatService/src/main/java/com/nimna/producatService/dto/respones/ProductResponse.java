package com.nimna.producatService.dto.respones;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private String productImage;
    private BigDecimal price;
}
