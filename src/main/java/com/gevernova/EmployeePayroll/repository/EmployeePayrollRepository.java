package com.gevernova.EmployeePayroll.repository;



import com.gevernova.EmployeePayroll.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository
        extends JpaRepository<EmployeePayrollData, Long> {

    @Query(value =
            "SELECT * FROM employee_payroll ep " +
                    "JOIN employee_department ed ON ep.employee_id = ed.employee_id " +
                    "WHERE ed.department = :department",
            nativeQuery = true)
    List<EmployeePayrollData> findEmployeesByDepartment(String department);
}

