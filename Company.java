/*
 Create a class name ‘Inventory’ containing three instance variables, two constructors and two methods. The data members
are "partno" of integer type, "partname" of string type and "cost" of float type. The constructors are a zero argument
constructor and a three argument constructor. The setInventory() method takes three arguments and sets the object. The
showInventory() method displays the details to the user. Create class "Company" containing the main function. Create
three objects of the class "Inventory". Create first object "I1" with the initial values 1, “RESISTOR” and 25.0 and create
another object "I2". Then take the details of "I2" from the user and then show the contents of both objects. Then create a
clone object from I2 and then show the contents.[Modify the program by adding constructor for creating clone object]
 */

import java.util.Scanner;

class Inventory{
    int partno;
    String partname;
    float cost;
    Inventory(){
        partno=0;
        partname="";
        cost=0;
    }
    Inventory(int partno,String partname,float cost){
        this.partno=partno;
        this.partname=partname;
        this.cost=cost;
    }
    Inventory(Inventory I){
        this.partno=I.partno;
        this.partname=I.partname;
        this.cost=I.cost;
    }

    void setInventory(int partno,String partname,float cost){
        this.partno=partno;
        this.partname=partname;
        this.cost=cost;
    }
    void showInventory(){
        System.out.println("Partno:"+partno);
        System.out.println("Partname:"+partname);
        System.out.println("Cost:"+cost);
    }

}

public class Company {
    public static void main(String[] args) {
        Inventory I1=new Inventory(1,"RESISTOR",25.0f);
        Inventory I2=new Inventory();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the partno,partname and cost of I2");
        int partno=sc.nextInt();
        String partname=sc.next();
        float cost=sc.nextFloat();
        I2.setInventory(partno,partname,cost);
        System.out.println("I1");
        I1.showInventory();
        System.out.println("I2");
        I2.showInventory();
        Inventory I3=new Inventory(I2);
        System.out.println("I2 cloned");
        I3.showInventory();
        sc.close();
    }
}
