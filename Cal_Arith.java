import java.util.Scanner;

class Arithop {
    static int nop = 0;

    public static int add(int a, int b) {
        nop++;
        return a + b;
    }

    public static int sub(int a, int b) {
        nop++;
        return a - b;
    }

    public static int mul(int a, int b) {
        nop++;
        return a * b;
    }

    public double div(int a, int b) {
        nop++;
        return (double) a / b;
    }
}

public class Cal_Arith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op1, op2;

        System.out.print("Enter the first operand (op1): ");
        op1 = scanner.nextInt();

        System.out.print("Enter the second operand (op2): ");
        op2 = scanner.nextInt();

        Arithop arith = new Arithop();

        // Performing addition and displaying the result and number of operations
        int sum = Arithop.add(op1, op2);
        System.out.println("Result of addition (op1 + op2): " + sum);
        System.out.println("Number of operations after addition: " + Arithop.nop);

        // Performing subtraction and displaying the result and number of operations
        int difference = Arithop.sub(op1, op2);
        System.out.println("Result of subtraction (op1 - op2): " + difference);
        System.out.println("Number of operations after subtraction: " + Arithop.nop);

        // Performing multiplication and displaying the result and number of operations
        int product = Arithop.mul(op1, op2);
        System.out.println("Result of multiplication (op1 * op2): " + product);
        System.out.println("Number of operations after multiplication: " + Arithop.nop);

        // Performing division and displaying the result and number of operations
        double quotient = arith.div(op1, op2);
        System.out.println("Result of division (op1 / op2): " + quotient);
        System.out.println("Number of operations after division: " + Arithop.nop);

        scanner.close();
    }
}

