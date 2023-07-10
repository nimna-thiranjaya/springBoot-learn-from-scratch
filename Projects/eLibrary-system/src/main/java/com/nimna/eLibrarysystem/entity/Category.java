package com.nimna.eLibrarysystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;

    @Column(name = "category_description", length = 200)
    private String categoryDescription;

    @Column(name = "category_status", columnDefinition = "TINYINT default 1")
    private boolean categoryStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}
