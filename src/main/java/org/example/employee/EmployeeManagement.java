package org.example.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeManagement {
    private List<Employee> employees;

    public EmployeeManagement() {
        employees = new ArrayList<>();
        employees.add(new Employee("Alice", 70000, "IT"));
        employees.add(new Employee("Bob", 50000, "HR"));
        employees.add(new Employee("Charlie", 120000, "IT"));
        employees.add(new Employee("David", 60000, "Finance"));
        employees.add(new Employee("Eve", 95000, "HR"));
    }

    public List<String> filterEmployeeNames(Predicate<Employee> condition) {
        return employees.stream()
                .filter(condition)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public double calculateTotalSalary(String department) {
        return employees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public String formatEmployeeDetails(Function<Employee, String> formatter) {
        return employees.stream()
                .map(formatter)
                .collect(Collectors.joining("\n"));
    }

    public Optional<Double> getEmployeeSalary(String name) {
        return employees.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .map(Employee::getSalary)
                .findFirst();
    }
}
