package com.nimna.usermanagementtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    private  String email;
    private String firstName;
    private String lastName;
    private  String password;
    private boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_ID")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> roles;
}
