package com.spring.Employee_Payroll_App.controller;

import com.spring.Employee_Payroll_App.model.EmployeePayroll;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollServiceController {

    @GetMapping(value = {"", "/"})
    public String getEmployeePayrollByDefault(){
        return "Get Employee payroll default route";
    }

    @GetMapping("/get/{id}")
    public String getEmployeePayrollById(@PathVariable String id){
        return "Get Employee payroll of Id: "+id;
    }

    @PostMapping("/create")
    public String createEmployeePayroll(@RequestBody EmployeePayroll employeePayroll){
        return "Create Employee payroll with name: "+employeePayroll.getName()+" and salary as "+employeePayroll.getSalary();
    }

    @PutMapping("/update")
    public String updateEmployeePayroll(@RequestBody EmployeePayroll employeePayroll){
        return "Update Employee payroll for name: "+employeePayroll.getName()+" and salary as "+employeePayroll.getSalary();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeePayrollById(@PathVariable String id){
        return "Delete Employee payroll of Id: "+id;
    }

}