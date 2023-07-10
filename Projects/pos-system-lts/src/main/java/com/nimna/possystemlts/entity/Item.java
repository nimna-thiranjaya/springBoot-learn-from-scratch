package com.nimna.possystemlts.entity;

import com.nimna.possystemlts.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data //we can use this data annotation for these annotations @Getter @Setter @ToString
public class Item {
    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 200, nullable = false)
    private String itemName;

    // only accept data in the enum
    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 100, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty")
    private double balanceQty;

    @Column(name = "supplier_price")
    private double supplierPrice;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "active_satatus", columnDefinition = "TINYINT default 0")
    private boolean activeStatus;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetails;
}
