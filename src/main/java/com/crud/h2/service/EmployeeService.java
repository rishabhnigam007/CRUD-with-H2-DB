package com.crud.h2.service;

import com.crud.h2.model.Employee;

import java.util.List;

public interface EmployeeService {
    
    public abstract Employee createEmployee(Employee e);

    public abstract void updateEmployee(Employee e);

    public abstract void deleteEmployee(int id);

    public abstract Employee getEmployee(int id);

    public abstract List<Employee> getEmployee();

    public abstract boolean isEmployeeExist(int id);
}