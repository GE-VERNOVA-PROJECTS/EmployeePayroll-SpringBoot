package com.gevernova.EmployeePayroll.service;


import com.gevernova.EmployeePayroll.dto.EmployeePayrollDTO;
import com.gevernova.EmployeePayroll.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    EmployeePayrollData createEmployee(EmployeePayrollDTO dto);
    EmployeePayrollData getEmployeeById(long id);
    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData updateEmployee(long id, EmployeePayrollDTO dto);
    void deleteEmployee(long id);
    List<EmployeePayrollData> getEmployeesByDepartment(String department);
}

