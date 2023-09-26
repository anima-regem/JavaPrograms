package P2;

import P1.BaseClass;

public class OtherPackage {
    public void show(BaseClass baseObj) {
   	 System.out.println("In OtherPackage:");
   	 
   	 System.out.println("Public variable (in OtherPackage): " + baseObj.publicVar);
    }
}
