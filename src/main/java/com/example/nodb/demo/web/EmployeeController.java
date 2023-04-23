package com.example.nodb.demo.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @GetMapping
    public CompletableFuture<List<Employee>> getEmployees() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return employeeRepository.findAllAsync();
    }
}
