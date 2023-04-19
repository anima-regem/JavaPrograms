/*
Create a class named "Student" having 6 instance variables: "name" of type string, "rollno" of type int,
"mark1","mark2","mark3" and "total" of type float. Declare 3 methods named "setstudent()","gettotal()" and "display()"
inside the class. "setstudent()" method is to set the values of the student and "gettotal()" method is to find and get the value
of the total marks and "display()" method is to display the details of the student. Create main class "Students" and in the
main function, enter the details of students into an array of student objects and then display the student details. Then
display the rank list
 */

import java.util.Scanner;

class Student {
    String name;
    int rollno;
    float mark1, mark2, mark3, total;

    void setstudent(String name, int rollno, float mark1, float mark2, float mark3) {
        this.name = name;
        this.rollno = rollno;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    float gettotal() {
        total = mark1 + mark2 + mark3;
        return total;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll no: " + rollno);
        System.out.println("Marks: " + mark1 + "," + mark2 + "," + mark3);
        System.out.println("Total: " + total);
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of students");
        n = sc.nextInt();

        Student[] s = new Student[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Student();
            System.out.println("Enter the name of student " + (i + 1));
            String name = sc.next();
            System.out.println("Enter the roll no of student " + (i + 1));
            int rollno = sc.nextInt();
            System.out.println("Enter the marks of student " + (i + 1));
            float mark1 = sc.nextFloat();
            float mark2 = sc.nextFloat();
            float mark3 = sc.nextFloat();
            s[i].setstudent(name, rollno, mark1, mark2, mark3);
        }
        for (int i = 0; i < n; i++) {
            s[i].gettotal();
            s[i].display();
        }

        sc.close();

    }
}
/*

Enter the number of students
2
Enter the name of student 1
Raj
Enter the roll no of student 1
23
Enter the marks of student 1
90
90
90
Enter the name of student 2
Sam
Enter the roll no of student 2
45
Enter the marks of student 2
99
95
92
Name: Raj
Roll no: 23
Marks: 90.0,90.0,90.0
Total: 270.0
Name: Sam
Roll no: 45
Marks: 99.0,95.0,92.0
Total: 286.0

 */