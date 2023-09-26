package P1;

public class DerivedClass extends BaseClass {
    public DerivedClass(int privateVar, int defaultVar, int protectedVar, int publicVar) {
   	 super(privateVar, defaultVar, protectedVar, publicVar);
    }

    public void show() {
   	 System.out.println("In DerivedClass:");
   	 
   	 System.out.println("Protected variable (in DerivedClass): " + protectedVar);
   	 System.out.println("Public variable (in DerivedClass): " + publicVar);
    }
}

