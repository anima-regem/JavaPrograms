import java.util.Scanner;

class Factorial{
    public int fact(int n){
        if(n==0)
            return 1;
        else
            return n*fact(n-1);
    }
}

public class nCr{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Factorial f = new Factorial();
        System.out.println("Enter the value of n and r");
        int n = sc.nextInt();
        int r = sc.nextInt();
        int ncr = f.fact(n)/(f.fact(r)*f.fact(n-r));
        System.out.println(ncr);
        sc.close();
    }
}