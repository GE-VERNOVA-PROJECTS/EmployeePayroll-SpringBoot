package com.gevernova.EmployeePayroll.controller;

import com.gevernova.EmployeePayroll.dto.EmployeePayrollDTO;
import com.gevernova.EmployeePayroll.dto.ResponseDTO;
import com.gevernova.EmployeePayroll.service.IEmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
@Validated
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService service;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getAll() {
        return ResponseEntity.ok(
                new ResponseDTO("Get All Employees", service.getAllEmployees()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable long id) {
        return ResponseEntity.ok(
                new ResponseDTO("Get Employee by ID", service.getEmployeeById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(
            @Valid @RequestBody EmployeePayrollDTO dto) {
        return ResponseEntity.ok(
                new ResponseDTO("Employee Created", service.createEmployee(dto)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(
            @PathVariable long id,
            @Valid @RequestBody EmployeePayrollDTO dto) {
        return ResponseEntity.ok(
                new ResponseDTO("Employee Updated", service.updateEmployee(id, dto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok(
                new ResponseDTO("Employee Deleted", id));
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getByDepartment(
            @PathVariable String department) {
        return ResponseEntity.ok(
                new ResponseDTO("Employees by Department",
                        service.getEmployeesByDepartment(department)));
    }
}

