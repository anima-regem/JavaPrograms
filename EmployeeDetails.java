// a Java class to store some employee details and provide methods to set and get values

import java.util.Scanner;

class Employee{
    int empId;
    String name;
    int age;
    String dept;

}

public class EmployeeDetails {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of employees");
        n = sc.nextInt();
        
        Employee[] emp = new Employee[n];
        for(int i=0;i<n;i++){
            emp[i] = new Employee();
            System.out.println("Enter the details of employee "+(i+1));
            System.out.println("Enter the employee id");
            emp[i].empId = sc.nextInt();
            System.out.println("Enter the employee name");
            emp[i].name = sc.next();
            System.out.println("Enter the employee age");
            emp[i].age = sc.nextInt();
            System.out.println("Enter the employee department");
            emp[i].dept = sc.next();
        }

        for(int i=0;i<n;i++){
            System.out.println("Employee "+(i+1)+" details");
            System.out.println("Employee id : "+emp[i].empId);
            System.out.println("Employee name : "+emp[i].name);
            System.out.println("Employee age : "+emp[i].age);
            System.out.println("Employee department : "+emp[i].dept);
        }

        sc.close();
    }
    
}
