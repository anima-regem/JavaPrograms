import java.util.Scanner;

/*
 The Fibonacci sequence is defined by the following rule. The first 2 values in the sequence are 0 and 1. Every subsequent
value is the sum of the 2 values preceding it. Develop a Java program that uses both recursive and no recursive functions to
print the nth value of the Fibonacci sequence
 */

class Fibonacci{
    int Fib(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        else
            return Fib(n-1)+Fib(n-2); //Fib(n-1) is the nth-1 value, Fib(n-2) is the nth-2 value, so Fib(n) = Fib(n-1)+Fib(n-2)
    }

    void Fib(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nth value of the Fibonacci sequence: ");
        int n = sc.nextInt();
        int a,b;
        a=0;
        b=1;
        for(int i=0;i<n;i++){
            b=a+b;
            a=b-a;
        }
        System.out.println(a);
        sc.close();
    }
}

public class FibMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Fibonacci f = new Fibonacci();
        int choice;
        do{
            System.out.println("Enter 1 for recursive function and 2 for non-recursive function: ");
            choice = sc.nextInt();
        }while(choice!=1 && choice!=2);

        if(choice==1){
            System.out.println("Enter the nth value");
            int n = sc.nextInt();
            System.out.println(f.Fib(n));
        }else{
            f.Fib();
        }
        sc.close();
    }
}

/*

Enter 1 for recursive function and 2 for non-recursive function: 
1
Enter the nth value
5
5

Enter 1 for recursive function and 2 for non-recursive function: 
2
Enter the nth value of the Fibonacci sequence: 
6
8

 */