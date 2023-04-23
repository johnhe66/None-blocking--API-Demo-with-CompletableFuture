package com.example.nodb.demo.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmployeeRepository {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public CompletableFuture<List<Employee>> findAllAsync() {
        return CompletableFuture.supplyAsync(this::findAll, executorService);
    }

    private List<Employee> findAll() {
        try {
            // Simulate a few seconds delay
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(1, "John Doe", "Software Engineer"),
                new Employee(2, "Jane Smith", "Project Manager"),
                new Employee(3, "Alice Johnson", "Data Analyst"),
                new Employee(4, "Bob Brown", "Quality Assurance Engineer"),
                new Employee(5, "Charlie Green", "Product Manager")
        ));

        return employees;
    }
}
