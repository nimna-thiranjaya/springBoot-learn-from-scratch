package com.nimna.possystemlts.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class OrderDetails {
    @Id
    @Column(name = "order_details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name = "item_name", length = 200, nullable = false)
    private String itemName;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order orders;

}
