package com.nimna.possystem.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.TypeDef;



import java.util.ArrayList;

@Entity
@Table(name = "customer") //Table name
//Configure json
@TypeDef(name = "json", typeClass = JsonStringType
        .class)
public class Customer {
    @Id //to annotate primary key
    @Column(name = "customer_id", length = 45) // column name is customer_id and length should be less than 45 digits
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false) //customer name field is required.
    private String customerName;

    @Column(name = "customer_address", length = 200) // address can be null
    private String customerAddress;

    @Column(name = "conatct_numbers", columnDefinition = "json")
    private ArrayList contactNumber;

}
