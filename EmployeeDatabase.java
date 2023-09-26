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

class AssistantProfessor extends Person {
    private String sub1;
    private String sub2;

    public AssistantProfessor(String name, int age, char gender, String sub1, String sub2) {
   	 super(name, age, gender);
   	 this.sub1 = sub1;
   	 this.sub2 = sub2;
    }

    @Override
    public void displayDetails() {
   	 super.displayDetails();
   	 System.out.println("Subject 1: " + sub1);
   	 System.out.println("Subject 2: " + sub2);
   	 System.out.println();
    }
}

class AssociateProfessor extends Person {
    private int numPapers;
    private String area;

    public AssociateProfessor(String name, int age, char gender, int numPapers, String area) {
   	 super(name, age, gender);
   	 this.numPapers = numPapers;
   	 this.area = area;
    }

    @Override
    public void displayDetails() {
   	 super.displayDetails();
   	 System.out.println("Number of Papers: " + numPapers);
   	 System.out.println("Research Area: " + area);
   	 System.out.println();
    }
}

class Professor extends Person {
    private int numPatents;
    private int numFundedProjects;

    public Professor(String name, int age, char gender, int numPatents, int numFundedProjects) {
   	 super(name, age, gender);
   	 this.numPatents = numPatents;
   	 this.numFundedProjects = numFundedProjects;
    }

    @Override
    public void displayDetails() {
   	 super.displayDetails();
   	 System.out.println("Number of Patents: " + numPatents);
   	 System.out.println("Number of Funded Projects: " + numFundedProjects);
   	 System.out.println();
    }
}

public class EmployeeDatabase {
    public static void main(String[] args) {
   	 Scanner scanner = new Scanner(System.in);
   	 int numEmployees = 15;
   	 Person[] employees = new Person[numEmployees];
   	 int count = 0;

   	 while (count < numEmployees) {
   		 System.out.println("Choose the employee category:");
   		 System.out.println("1. Assistant Professor");
   		 System.out.println("2. Associate Professor");
   		 System.out.println("3. Professor");
   		 System.out.println("4. Exit");
   		 System.out.print("Enter your choice: ");
   		 int choice = scanner.nextInt();
   		 scanner.nextLine();

   		 switch (choice) {
       		 case 1:
           		 System.out.print("Enter name: ");
           		 String name = scanner.nextLine();
           		 System.out.print("Enter age: ");
           		 int age = scanner.nextInt();
           		 scanner.nextLine();
           		 System.out.print("Enter gender (M/F): ");
           		 char gender = scanner.nextLine().charAt(0);
           		 System.out.print("Enter Subject 1: ");
           		 String sub1 = scanner.nextLine();
           		 System.out.print("Enter Subject 2: ");
           		 String sub2 = scanner.nextLine();

           		 employees[count] = new AssistantProfessor(name, age, gender, sub1, sub2);
           		 count++;
           		 break;

       		 case 2:
           		 System.out.print("Enter name: ");
           		 name = scanner.nextLine();
           		 System.out.print("Enter age: ");
           		 age = scanner.nextInt();
           		 scanner.nextLine();
           		 System.out.print("Enter gender (M/F): ");
           		 gender = scanner.nextLine().charAt(0);
           		 System.out.print("Enter number of papers: ");
           		 int numPapers = scanner.nextInt();
           		 scanner.nextLine();
           		 System.out.print("Enter research area: ");
           		 String area = scanner.nextLine();

           		 employees[count] = new AssociateProfessor(name, age, gender, numPapers, area);
           		 count++;
           		 break;

       		 case 3:
           		 System.out.print("Enter name: ");
           		 name = scanner.nextLine();
           		 System.out.print("Enter age: ");
           		 age = scanner.nextInt();
           		 scanner.nextLine();
           		 System.out.print("Enter gender (M/F): ");
           		 gender = scanner.nextLine().charAt(0);
           		 System.out.print("Enter number of patents: ");
           		 int numPatents = scanner.nextInt();
           		 System.out.print("Enter number of funded projects: ");
           		 int numFundedProjects = scanner.nextInt();

           		 employees[count] = new Professor(name, age, gender, numPatents, numFundedProjects);
           		 count++;
           		 break;

       		 case 4:
           		 count = numEmployees;
           		 break;

       		 default:
           		 System.out.println("Invalid choice. Please try again.");
           		 break;
   		 }
   	 }

   	 System.out.println("\nEmployee Details:");
   	 for (Person employee : employees) {
   		 if (employee != null) {
       		 employee.displayDetails();
   		 }
   	 }

   	 scanner.close();
    }
}
