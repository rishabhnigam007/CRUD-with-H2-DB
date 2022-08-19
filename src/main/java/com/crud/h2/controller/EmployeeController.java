package com.crud.h2.controller;

import com.crud.h2.exception.EmployeeNotFoundException;
import com.crud.h2.model.Employee;
import com.crud.h2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService es;

    @PostMapping("/register")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee e) {
        e = es.createEmployee(e);
        return new ResponseEntity<Object>("Employee is created successfully " + e.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody Employee e) {
        boolean isexist = es.isEmployeeExist(id);
        if (isexist) {
            e.setId(id);
            es.updateEmployee(e);
            return new ResponseEntity<Object>("Employee is updated successfully " + e.getId(), HttpStatus.OK);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) throws Exception {
        boolean isexist = es.isEmployeeExist(id);
        if (isexist) {
            es.deleteEmployee(id);
            return new ResponseEntity<Object>("Employee Deleted successfully with ID : " + id, HttpStatus.GONE);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {
        boolean isexist = es.isEmployeeExist(id);
        if (isexist) {
            Employee e = es.getEmployee(id);
            return new ResponseEntity<Object>("Employee : " + e.toString(), HttpStatus.OK);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @GetMapping("/allemployee")
    public ResponseEntity<Object> getAllEmployee() {
        List<Employee> list = es.getEmployee();
        return new ResponseEntity<Object>(list.toString(), HttpStatus.OK);
    }

}