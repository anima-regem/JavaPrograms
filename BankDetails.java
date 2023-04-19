import java.util.Scanner;

class Bank {
    int accno;
    String name;
    String type;
    int balance;

    public void display() {
        System.out.println("Account No : " + accno);
        System.out.println("Name : " + name);
        System.out.println("Type : " + type);
        System.out.println("Balance : " + balance);
    }

}

public class BankDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank b = new Bank();
        System.out.println("Enter Account No : ");
        b.accno = sc.nextInt();
        System.out.println("Enter Name : ");
        b.name = sc.next();
        System.out.println("Enter Type : ");
        b.type = sc.next();
        System.out.println("Enter Balance : ");
        b.balance = sc.nextInt();
        b.display();
        sc.close();

    }
}

/*

Enter Account No : 
2342
Enter Name : 
Raj
Enter Type : 
FD
Enter Balance : 
3420
Account No : 2342
Name : Raj
Type : FD
Balance : 3420

 */