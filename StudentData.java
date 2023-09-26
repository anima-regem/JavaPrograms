import java.util.Scanner;

class Person {
    protected String name;
    protected int age;
    protected char gender;

    public Person(String name, int age, char gender) {
   	 this.name = name;
   	 this.age = age;
   	 this.gender = gender;
    }

    public void displayDetails() {
   	 System.out.println("Name: " + name);
   	 System.out.println("Age: " + age);
   	 System.out.println("Gender: " + gender);
    }
}

class Student extends Person {
    private int mark1;
    private int mark2;
    private int mark3;
    private int totalMarks;
    private char grade;

    public Student(String name, int age, char gender, int mark1, int mark2, int mark3) {
   	 super(name, age, gender);
   	 this.mark1 = mark1;
   	 this.mark2 = mark2;
   	 this.mark3 = mark3;
   	 this.totalMarks = mark1 + mark2 + mark3;
   	 this.grade = calculateGrade();
    }

    private char calculateGrade() {
   	 double percentage = totalMarks / 3.0;
   	 if (percentage >= 90) {
   		 return 'A';
   	 } else if (percentage >= 80) {
   		 return 'B';
   	 } else if (percentage >= 70) {
   		 return 'C';
   	 } else if (percentage >= 60) {
   		 return 'D';
   	 } else {
   		 return 'F';
   	 }
    }

    public void displayDetails() {
   	 super.displayDetails();
   	 System.out.println("Mark1: " + mark1);
   	 System.out.println("Mark2: " + mark2);
   	 System.out.println("Mark3: " + mark3);
   	 System.out.println("Total Marks: " + totalMarks);
   	 System.out.println("Grade: " + grade);
   	 System.out.println();
    }
}

public class StudentData {
    public static void main(String[] args) {
   	 Scanner scanner = new Scanner(System.in);

   	 System.out.print("Enter the number of students: ");
   	 int numStudents = scanner.nextInt();

   	 
   	 scanner.nextLine();

   	 Student[] students = new Student[numStudents];

   	 for (int i = 0; i < numStudents; i++) {
   		 System.out.println("\nEnter details for student " + (i + 1) + ":");
   		 System.out.print("Name: ");
   		 String name = scanner.nextLine();

   		 System.out.print("Age: ");
   		 int age = scanner.nextInt();

   		 scanner.nextLine();

   		 System.out.print("Gender (M/F): ");
   		 char gender = scanner.nextLine().charAt(0);

   		 System.out.print("Mark1: ");
   		 int mark1 = scanner.nextInt();

   		 System.out.print("Mark2: ");
   		 int mark2 = scanner.nextInt();

   		 System.out.print("Mark3: ");
   		 int mark3 = scanner.nextInt();

   		 
   		 scanner.nextLine();

   		 students[i] = new Student(name, age, gender, mark1, mark2, mark3);
   	 }

   	 System.out.println("\nStudent Details:");

   	 for (Student student : students) {
   		 student.displayDetails();
   	 }

   	 scanner.close();
    }
}
