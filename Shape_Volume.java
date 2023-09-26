/*

Create a class called Shape. Implement methods to find the volume of a cube, cylinder and rectangle prism using the
concept of method overloading

 */

import java.util.Scanner;

class Shape{
    double volume(double x){
        return x*x*x;
    }
    double volume(double x, double y){
        return 3.14*x*x*y;
    }
    double volume(double x, double y, double z){
        return x*y*z;
    }
}

public class Shape_Volume {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Shape z=new Shape();
        System.out.println("Enter the side of the cube");
        double a=sc.nextDouble();
        System.out.println("Volume of cube is "+z.volume(a));
        System.out.println("Enter the radius and height of the cylinder");
        a=sc.nextDouble();        
        double b=sc.nextDouble();
        System.out.println("Volume of cylinder is "+z.volume(a,b));
        System.out.println("Enter the length, breadth and height of the cube");
        a=sc.nextDouble();
        b=sc.nextDouble();
        double c= sc.nextDouble();
        System.out.println("Volume of cuboid is "+z.volume(a,b,c));
        sc.close();
    }
}
/*

Enter the side of the cube
4
Volume of cube is 64.0
Enter the radius and height of the cylinder
4 5
Volume of cylinder is 251.20000000000002
Enter the length, breadth and height of the cube
2 5 7
Volume of cuboid is 70.0

 */
