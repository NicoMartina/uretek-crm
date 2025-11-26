package com.uretek_crm.uretek_crm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "crm_user") // Avoid conflict with reserved 'user' keyword in some databases
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String usernaame;

    @Column(nullable = false)
    private String password; //Hashed password

    @ElementCollection(fetch = FetchType.EAGER) // Roles are loaded immediately
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

}
