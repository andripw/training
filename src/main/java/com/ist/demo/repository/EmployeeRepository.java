package com.ist.demo.repository;

import com.ist.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByEmail(String email);

    //public List<Employee> findByUsername(String username);

    //public List<Employee> findByEmailandUsername(String email, String username);

    //public List<Employee> findByEmailorUsername(String email, String username);
}
