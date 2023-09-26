// a Java class to store some employee details and provide methods to set and get values

import java.util.Scanner;

class Employee {
    int empId;
    String name;
    int age;
    String dept;
    float salary;

    void getData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee id");
        empId = sc.nextInt();
        System.out.println("Enter the employee name");
        name = sc.next();
        System.out.println("Enter the employee age");
        age = sc.nextInt();
        System.out.println("Enter the employee department");
        dept = sc.next();
    }

    void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Department : " + dept);
        System.out.println("Salary : " + salary);
    }

}

public class EmployeeDetails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of employees");
        n = sc.nextInt();

        Employee[] emp = new Employee[n];
        for (int i = 0; i < n; i++) {
            emp[i] = new Employee();
            System.out.println("Enter the details of employee " + (i + 1));

        }

        for (int i = 0; i < n; i++) {
            System.out.println("Employee " + (i + 1) + " details");
            System.out.println("Employee id : " + emp[i].empId);
            System.out.println("Employee name : " + emp[i].name);
            System.out.println("Employee age : " + emp[i].age);
            System.out.println("Employee department : " + emp[i].dept);
        }

        sc.close();
    }

}

/*
 
 Enter the number of employees
 2
 Enter the details of employee 1
 Enter the employee id
 1
 Enter the employee name
 Emp1
 Enter the employee age
 34
 Enter the employee department
 IT
 Enter the details of employee 2
 Enter the employee id
 2
 Enter the employee name
 Emp2
 Enter the employee age
 32
 Enter the employee department
 IT
 Employee 1 details
 Employee id : 1
 Employee name : Emp1
 Employee age : 34
 Employee department : IT
 Employee 2 details
 Employee id : 2
 Employee name : Emp2
 Employee age : 32
 Employee department : IT
 
 */