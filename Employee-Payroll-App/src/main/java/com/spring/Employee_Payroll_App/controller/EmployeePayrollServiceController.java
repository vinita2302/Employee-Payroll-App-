package com.spring.Employee_Payroll_App.controller;


import com.spring.Employee_Payroll_App.dto.EmployeePayrollDto;
import com.spring.Employee_Payroll_App.model.EmployeePayroll;
import com.spring.Employee_Payroll_App.service.EmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.Employee_Payroll_App.model.EmployeePayroll;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employee-payroll-service")
public class EmployeePayrollServiceController {


    @Autowired
    private EmployeePayrollService employeePayrollService;



    @GetMapping(value = {"", "/"})
    public String getEmployeePayrollByDefault(){
        log.info("Getting employee payroll by default");
        return "Get Employee payroll default route";
    }

    @GetMapping("/get/{name}")
    public EmployeePayroll getEmployeePayrollByName(@PathVariable String name){
        log.info("Getting employee payroll of name {}", name);
        EmployeePayroll employeePayroll = employeePayrollService.getEmployeePayrollByName(name);
        log.info("Employee payroll fetched of name {}", employeePayroll);
        return employeePayroll;
    }

    @GetMapping("/get/all")
    public List<EmployeePayroll> getEmployeePayrolls(){
        log.info("Getting all employee payroll");
        List<EmployeePayroll> employeePayrolls = employeePayrollService.getEmployeePayrolls();
        log.info("all employee payroll fetched {}", employeePayrolls);
        return employeePayrolls;
    }

    @PostMapping("/create")
    public EmployeePayroll createEmployeePayroll(@RequestBody EmployeePayrollDto employeePayroll){
        log.info("creating employee payroll using following employee payroll dto {}", employeePayroll);
        EmployeePayroll newEmployeePayroll = employeePayrollService.createEmployeePayroll(employeePayroll);
        log.info("new employee payroll created using employee payroll dto is {}", newEmployeePayroll);
        return newEmployeePayroll;
    }

    @PutMapping("/update")
    public EmployeePayroll updateEmployeePayroll(@RequestBody EmployeePayrollDto employeePayrollDto){
        log.info("updating employee payroll using employee payroll dto {}", employeePayrollDto);
        EmployeePayroll updatedEmployeePayroll = employeePayrollService.updateEmployeePayroll(employeePayrollDto);
        log.info("updated employee payroll using employee payroll dto is {}", updatedEmployeePayroll);
        return updatedEmployeePayroll;

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

        log.info("delete employee payroll of id {}", id);
        String deletedResponse = employeePayrollService.deleteEmployeePayrollById(Long.parseLong(id));
        if(!deletedResponse.isEmpty()) log.info("deleted employee payroll");
        return deletedResponse;

        return employeePayrollService.deleteEmployeePayrollById(String.valueOf(Long.parseLong(id)));


    }

}