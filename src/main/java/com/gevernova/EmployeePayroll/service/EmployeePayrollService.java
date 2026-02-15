package com.gevernova.EmployeePayroll.service;


import com.gevernova.EmployeePayroll.dto.EmployeePayrollDTO;
import com.gevernova.EmployeePayroll.exception.EmployeePayrollException;
import com.gevernova.EmployeePayroll.model.EmployeePayrollData;
import com.gevernova.EmployeePayroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repository;

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO dto) {
        EmployeePayrollData data = new EmployeePayrollData(0, dto);
        return repository.save(data);
    }

    @Override
    public EmployeePayrollData getEmployeeById(long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new EmployeePayrollException("Employee not found with id " + id));
    }

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeePayrollData updateEmployee(long id, EmployeePayrollDTO dto) {
        EmployeePayrollData data = getEmployeeById(id);
        data = new EmployeePayrollData(id, dto);
        return repository.save(data);
    }

    @Override
    public void deleteEmployee(long id) {
        EmployeePayrollData data = getEmployeeById(id);
        repository.delete(data);
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return repository.findEmployeesByDepartment(department);
    }
}

