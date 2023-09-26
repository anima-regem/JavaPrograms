package P1;

public class MainClass {
    public static void main(String[] args) {
   	 P1.BaseClass baseObj = new P1.BaseClass(10, 20, 30, 40);
   	 P1.DerivedClass derivedObj = new P1.DerivedClass(50, 60, 70, 80);
   	 P1.SamePackage samePackageObj = new P1.SamePackage();
   	 P2.OtherDerivedClass otherDerivedObj = new P2.OtherDerivedClass(90, 100, 110, 120);
   	 P2.OtherPackage otherPackageObj = new P2.OtherPackage();

   	 baseObj.showValues();
   	 derivedObj.show();
   	 samePackageObj.show(baseObj);
   	 otherDerivedObj.show();
 otherPackageObj.show(baseObj);     
          }
}
