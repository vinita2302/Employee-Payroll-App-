package com.spring.Employee_Payroll_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollServiceController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping(value = {"", "/"})
    public String getEmployeePayrollByDefault(){
        return "Get Employee payroll default route";
    }

    @GetMapping("/get/{name}")
    public EmployeePayroll getEmployeePayrollByName(@PathVariable String name){
        return employeePayrollService.getEmployeePayrollByName(name);
    }

    @GetMapping("/get/all")
    public List<EmployeePayroll> getEmployeePayrolls(){
        return employeePayrollService.getEmployeePayrolls();
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployeePayroll(@RequestBody EmployeePayrollDto employeePayroll){
        return employeePayrollService.createEmployeePayroll(employeePayroll);
    }

    @PutMapping("/update")
    public EmployeePayroll updateEmployeePayroll(@RequestBody EmployeePayrollDto employeePayroll){
        return employeePayrollService.updateEmployeePayroll(employeePayroll);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeePayrollById(@PathVariable String id){
        return employeePayrollService.deleteEmployeePayrollById(Long.parseLong(id));
    }

}