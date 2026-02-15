package com.gevernova.EmployeePayroll.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @NotNull
    public List<String> department;

    @Min(value = 500, message = "Salary should be more than 500")
    public long salary;

    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent
    @NotNull
    public LocalDate startDate;

    @NotBlank
    public String note;

    @NotBlank
    public String profilePic;
}

