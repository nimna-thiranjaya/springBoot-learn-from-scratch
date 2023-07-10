package com.nimna.possystemlts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customers;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;

    public Order(double total, Date orderDate, Customer customers) {
        this.total = total;
        this.orderDate = orderDate;
        this.customers = customers;
    }
}
