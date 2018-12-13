/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author eck
 */
class Employee {

    public enum Gender {

        MALE{
            @Override
            public String toString() {
                return "male";
            }
        }, FEMALE{
            @Override
            public String toString() {
                return "female";
            }
        };

        @Override
        public abstract String toString();
    }

    private UUID employeeID;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    private Employee(String name, Gender gender, LocalDate dob,
            double income) {
        
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
        employeeID = UUID.randomUUID();
    }

    public Employee() {
    }

    public double getIncome() {
        return income;
    }

    public static List<Employee> persons() {
        Employee p1 = new Employee( "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        Employee p2 = new Employee("Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        Employee p3 = new Employee( "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        Employee p4 = new Employee("Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        Employee p5 = new Employee( "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        Employee p6 = new Employee( "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<Employee> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    public static void statistics() {
        List<Employee> list = persons();
        list.stream()
                .map(Employee::getIncome)
                .reduce((x, y) -> x + y)
                .ifPresent(System.out::println);
    }

    public static void personsStatsByGenderCount(){
        List<Employee> list = persons();

        Map<Gender, Long> groupsByGender =
                list.stream()
                .collect(Collectors.groupingBy(x -> x.gender,
                        Collectors.counting()));

        groupsByGender.forEach((gender, count) ->
                System.out.printf("%d employees are %s.%n",
                        count, gender));
    }

    public static void personsStatsByGenderList(){
        List<Employee> list = persons();

        Map<Gender, List<Employee>> groups = list.stream()
                .collect(Collectors.groupingBy(x -> x.gender));

        groups.forEach((gender, group) ->
        {
            System.out.printf("%s employees:%n", gender);
            group.forEach(System.out::println);
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeID, employee.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", income=" + income +
                '}';
    }
}

