package ru.gb.lesson5;

import ru.gb.lesson5.Employee;

import java.util.Arrays;
import java.util.stream.Collectors;

public class lesson5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Сафронов Тимофей", "программист", "employee1@test.com",
                "+7987654321", (int)(Math.random() * 1000), (int)(Math.random() * 40 + 25));
        employees[1] = new Employee("Ермаков Максим", "программист", "employee2@test.com",
                "+7987654322", (int)(Math.random() * 1000), (int)(Math.random() * 40 + 25));
        employees[2] = new Employee("Мотузок Виктория", "программист", "employee3@test.com",
                "+7987654323", (int)(Math.random() * 1000), (int)(Math.random() * 40 + 25));
        employees[3] = new Employee("Ероховец Алексей", "программист", "employee4@test.com",
                "+7987654324", (int)(Math.random() * 1000), (int)(Math.random() * 40 + 25));
        employees[4] = new Employee("Гладкова Анна", "программист", "employee5@test.com",
                "+7987654325", (int)(Math.random() * 1000), (int)(Math.random() * 40 + 25));
        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee.printInfo());
        }
        System.out.println("");
        System.out.println("Список сотрудников старше 40 (поиск путем перебора)");
        int employeeCount = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee.printInfo());
                employeeCount++;
            }
        }
        System.out.println("Всего сотрудников: " + employeeCount);
        System.out.println("");
        System.out.println("Список сотрудников старше 40 (фильтрация в потоке)");
        Employee[] over40EmployeesStream = Arrays.stream(employees)
                .filter(emp -> emp.getAge() > 40)
                .toArray(Employee[]::new);
        if (over40EmployeesStream.length > 0) {
            for (Employee employee : over40EmployeesStream) {
                System.out.println(employee.printInfo());
            }
        }
        System.out.println("Всего сотрудников: " + over40EmployeesStream.length);
    }
}
