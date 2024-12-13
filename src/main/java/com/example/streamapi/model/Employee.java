package com.example.streamapi.model;

import lombok.ToString;

@ToString
public class Employee {
    String name;
    int age;
    double salary;
    String department;
    String role;

    // Constructor, getters and setters
    public Employee(String name, int age, double salary, String department, String role) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }
}
