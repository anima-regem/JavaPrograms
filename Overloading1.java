/*

Create a class called Shape. Implement methods to find the volume of a cube, cylinder and rectangle prism using the
concept of method overloading

 */

import java.util.Scanner;

class Shape{
    double vol;
    void volume(int l,int b,int h){
        vol=l*b*h;
        System.out.println("Volume of cube is "+vol);
    }
    void volume(int r,int h){
        vol=3.14*r*r*h;
        System.out.println("Volume of cylinder is "+vol);
    }
    void volume(int a){
        vol=a*a*a;
        System.out.println("Volume of cube is "+vol);
    }
}

public class Overloading1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Shape s=new Shape();
        System.out.println("Enter the length, breadth and height of the cube");
        int l=sc.nextInt();
        int b=sc.nextInt();
        int h=sc.nextInt();
        s.volume(l,b,h);
        System.out.println("Enter the radius and height of the cylinder");
        int r=sc.nextInt();
        int h1=sc.nextInt();
        s.volume(r,h1);
        System.out.println("Enter the side of the cube");
        int a=sc.nextInt();
        s.volume(a);
        sc.close();
    }
}
