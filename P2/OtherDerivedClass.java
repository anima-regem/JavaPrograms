package P2;

import P1.BaseClass;

public class OtherDerivedClass extends BaseClass {
    public OtherDerivedClass(int privateVar, int defaultVar, int protectedVar, int publicVar) {
   	 super(privateVar, defaultVar, protectedVar, publicVar);
    }

    public void show() {
   	 System.out.println("In OtherDerivedClass (Package P2):");
   	 
   	 System.out.println("Protected variable (in OtherDerivedClass): " + protectedVar);
   	 System.out.println("Public variable (in OtherDerivedClass): " + publicVar);
    }
}
