package com.ist.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EMP_PERMISSIONS")
@Data
public class Permission {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private int id;

    @Column(name = "URL")
    private String url;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    @JsonBackReference
    private Role role;
}
