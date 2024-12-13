package com.example.streamapi;

import com.example.streamapi.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIPractice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, 50000, "Engineering", "Developer"),
                new Employee("Bob", 40, 80000, "Engineering", "Manager"),
                new Employee("Charlie", 35, 60000, "Marketing", "Executive"),
                new Employee("David", 45, 70000, "HR", "Manager"),
                new Employee("Eva", 28, 40000, "Engineering", "Developer"),
                new Employee("Frank", 50, 90000, "Marketing", "Manager")
        );

        // 1. Filter employees by department
        List<Employee> employeeByDepartment = employees.stream()
                .filter(employee -> employee.getDepartment() == "Engineering")
                .collect(Collectors.toList());
        System.out.println("Employee from Engineering Department");
        employeeByDepartment.forEach(employee -> System.out.println(employee));

        // 2. Calculate the average salary of all employee
        System.out.println("------Calculate the average salary of all employee");
        double employeeAverageSalay = employees.stream()
                .mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println("Average Salary: " + employeeAverageSalay);

        // 3. Group employees by role
        System.out.println("------Group employees by role");
        Map<String, List<Employee>> groupEmployeeByRole = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));
        groupEmployeeByRole.forEach((role, employeeList) -> {
            System.out.println("Role: " + role.toUpperCase());
            employeeList.forEach(employee -> System.out.println(employee.getName()));
            System.out.println();
        });

        // 4. Get a sorted list of employees' names based on salary
        System.out.println("------Get a sorted list of employees' names based on salary");
        List<Employee> sortedEmployeeBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        sortedEmployeeBySalary.forEach(employee -> {
            System.out.println("Name: " + employee.getName() + "Salary: " + employee.getSalary()) ;
        });

        // 5. Get the first employee with salary above 60,000
        System.out.println("------Get the first employee with salary above 60,000");
        Optional<Employee> employeeWithSalaryAbove60000 = employees.stream()
                .filter(employee -> employee.getSalary() > 50000D)
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .findFirst();
        employeeWithSalaryAbove60000.ifPresent(employee -> System.out.println("First employee with salary above 60,000 : " + employee.getName()));


        // 6. Create a map of employee names and their salaries
        System.out.println("------Create a map of employee names and their salaries");
        Map<String, Double> employeeMapBySalary = employees.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        employeeMapBySalary.forEach((name, salary)->{
            System.out.println("Name: " + name + ", Salary: " + salary);
        });

        // 7. Create a list of employee names concatenated with their salary
        System.out.println("------Create a list of employee names concatenated with their salary");
        List<String> employeeConSalary = employees.stream().map(employee -> employee.getName() + employee.getSalary())
                .collect(Collectors.toList());
        employeeConSalary.forEach(System.out::println);

    }
}
