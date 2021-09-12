package com.ist.demo.entity;

import com.ist.demo.repository.EmployeeRepository;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private int id;

    @Column(name = "EMPLOYEE_USERNAME")
    private String name;

    @Column(name = "EMPLOYEE_EMAIL")
    private String email;

    @OneToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;
}
