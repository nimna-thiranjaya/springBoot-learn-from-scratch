package com.nimna.inventoryService.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String skuCode;
    private Integer quantity;
}
