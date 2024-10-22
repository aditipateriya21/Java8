package org.example.employee;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        System.out.println("Employees with salary greater than $60,000:");
        List<String> highEarners = management.filterEmployeeNames(emp -> emp.getSalary() > 60000);
        highEarners.forEach(System.out::println);

        double totalITSalary = management.calculateTotalSalary("IT");
        System.out.printf("\nTotal salary in IT department: $%.2f%n", totalITSalary);

        String formattedDetails = management.formatEmployeeDetails(emp ->
                String.format("Name: %s, Salary: %.2f, Department: %s", emp.getName(), emp.getSalary(), emp.getDepartment())
        );
        System.out.println("\nEmployee Details:\n" + formattedDetails);

        String employeeName = "Alice";
        Optional<Double> salary = management.getEmployeeSalary(employeeName);
        salary.ifPresentOrElse(
                s -> System.out.printf("\n%s's salary: $%.2f%n", employeeName, s),
                () -> System.out.printf("\nEmployee %s not found.%n", employeeName)
        );
    }
}
