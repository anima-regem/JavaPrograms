import java.util.Scanner;

class Customer {
    private String name;
    private DateOfBirth dob;
    private String designation;

    public Customer(String name, int day, int month, int year, String designation) {
        this.name = name;
        this.dob = new DateOfBirth(day, month, year);
        this.designation = designation;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Designation: " + designation);
    }

    private class DateOfBirth {
        private int day;
        private int month;
        private int year;

        public DateOfBirth(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public String toString() {
            return day + "/" + month + "/" + year;
        }
    }
}

public class CustomerDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter date of birth (day month year): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter customer designation: ");
        String designation = scanner.nextLine();

        Customer customer = new Customer(name, day, month, year, designation);

        System.out.println("\nCustomer Details:");
        customer.displayDetails();

        scanner.close();
    }
}

