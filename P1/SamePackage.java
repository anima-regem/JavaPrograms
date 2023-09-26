package P1;

public class SamePackage {
    public void show(BaseClass baseObj) {
   	 System.out.println("In SamePackage:");
   	 
   	 System.out.println("Default variable (in SamePackage): " + baseObj.defaultVar);
   	 System.out.println("Protected variable (in SamePackage): " + baseObj.protectedVar);
   	 System.out.println("Public variable (in SamePackage): " + baseObj.publicVar);
    }
}

