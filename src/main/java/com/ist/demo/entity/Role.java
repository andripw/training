package com.ist.demo.entity;

import lombok.Data;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "EMP_ROLE")
@Data
public class Role {

    @Id
    @Column(name = "ROLE_ID")
    private int id;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "PERMISSION_DESC")
    private String permissionsDesc;

    @OneToMany(mappedBy = "role")
    private List<Permission> permission;
}
