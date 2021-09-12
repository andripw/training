package com.ist.demo.controller;

import com.ist.demo.entity.Employee;
import com.ist.demo.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> result = employeeRepository.findAll();
        if(result == null || result.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        try {
            Employee e = employeeRepository.save(employee);
            return new ResponseEntity<>(e, HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Error saving {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<String> deleteEmployee(@RequestParam Integer employeeID){
        try {
            employeeRepository.deleteById(employeeID);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }catch (Exception e){
            log.error("Error deleting user {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<List<Employee>> getByEmail(@RequestParam String email){
        List<Employee> result = employeeRepository.findByEmail(email);
        if(result == null || result.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
