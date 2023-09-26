package P1;

public class BaseClass {
    private int privateVar;
    int defaultVar;
    protected int protectedVar;
    public int publicVar;

    public BaseClass(int privateVar, int defaultVar, int protectedVar, int publicVar) {
   	 this.privateVar = privateVar;
   	 this.defaultVar = defaultVar;
   	 this.protectedVar = protectedVar;
   	 this.publicVar = publicVar;
    }

    public void showValues() {
   	 System.out.println("Private variable: " + privateVar);
   	 System.out.println("Default variable: " + defaultVar);
   	 System.out.println("Protected variable: " + protectedVar);
   	 System.out.println("Public variable: " + publicVar);
    }
}
