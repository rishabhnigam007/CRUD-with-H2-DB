package com.crud.h2.service.impl;

import com.crud.h2.model.Employee;
import com.crud.h2.repository.EmployeeRepository;
import com.crud.h2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository er;

    @Override
    public Employee createEmployee(Employee e) {
        return er.save(e);
    }

    @Override
    public void updateEmployee(Employee e) {
        er.saveAndFlush(e);
    }

    @Override
    public void deleteEmployee(int id) {
        er.deleteById(id);
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> op = er.findById(id);
        Employee e = op.get();
        return e;
    }

    @Override
    public List<Employee> getEmployee() {
        List<Employee> allEmployee = er.findAll();
        System.out.println("Getting data : " + allEmployee);
        return allEmployee;
    }

    @Override
    public boolean isEmployeeExist(int id) {
        return er.existsById(id);
    }

}