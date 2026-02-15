package com.gevernova.EmployeePayroll.model;
import com.gevernova.EmployeePayroll.dto.EmployeePayrollDTO;

import lombok.Data;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
@Data
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    private String name;
    private String gender;
    private long salary;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id")
    )
    private List<String> department;

    public EmployeePayrollData() {}

    public EmployeePayrollData(long employeeId, EmployeePayrollDTO dto) {
        this.employeeId = employeeId;
        this.name = dto.name;
        this.gender = dto.gender;
        this.salary = dto.salary;
        this.startDate = dto.startDate;
        this.note = dto.note;
        this.profilePic = dto.profilePic;
        this.department = dto.department;
    }
}

