package Shape;

interface Shape {
    void printArea();
}


class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
   	 this.length = length;
   	 this.width = width;
    }

    @Override
    public void printArea() {
   	 double area = length * width;
   	 System.out.println("Area of Rectangle: " + area);
    }
}


class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
   	 this.base = base;
   	 this.height = height;
    }

    @Override
    public void printArea() {
   	 double area = 0.5 * base * height;
   	 System.out.println("Area of Triangle: " + area);
    }
}


class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
   	 this.radius = radius;
    }

    @Override
    public void printArea() {
   	 double area = Math.PI * radius * radius;
   	 System.out.println("Area of Circle: " + area);
    }
}


public class Main {
    public static void main(String[] args) {
   	 
   	 Rectangle rectangle = new Rectangle(5.0, 3.0);
   	 Triangle triangle = new Triangle(4.0, 6.0);
   	 Circle circle = new Circle(2.5);

   	 
   	 rectangle.printArea();
   	 triangle.printArea();
   	 circle.printArea();
    }
}
