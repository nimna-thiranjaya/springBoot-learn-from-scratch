package com.nimna.usermanagementtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Role {

    @Id
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_desc")
    private String roleDescription;

    @Column(name = "role_status")
    private int roleStatus;
}
