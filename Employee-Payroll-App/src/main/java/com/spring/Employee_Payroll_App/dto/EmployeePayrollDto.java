package com.spring.Employee_Payroll_App.dto;

public class EmployeePayrollDto {

    private String name;
    private double salary;

    public EmployeePayrollDto() {}

    public EmployeePayrollDto(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
