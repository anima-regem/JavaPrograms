import java.util.Scanner;

/*

Develop a Java program to implement functions to display an integer, string and float values using the concept of method
overloading

 */

 class Overloader{
     void display(int a){
         System.out.println("Integer value is "+a);
     }
     void display(String a){
         System.out.println("String value is "+a);
     }
     void display(float a){
         System.out.println("Float value is "+a);
     }
 }

public class Overloading2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Overloader obj = new Overloader();
        System.out.println("Enter the integer value");
        int a = sc.nextInt();
        obj.display(a);
        System.out.println("Enter the string value");
        String b = sc.next();
        obj.display(b);
        System.out.println("Enter the float value");
        float c = sc.nextFloat();
        obj.display(c);
        sc.close();
    }
}
