class Human{
    String name;
    int age;

    Human(){
        System.out.println("Human object is created");
    }

    void eat(){
        System.out.println("Human is eating");
    }
}

class Student extends Human{
    Student(){
        System.out.println("Student object is created");
    }
    void eat(){
        System.out.println("I am a student!");
    }
}

class Teacher extends Human{

    Teacher(){
        System.out.println("Teacher object is created");
    }
    void eat(){
        System.out.println("I am a student!");
    }
}

public class InheritanceStudy {
    public static void main(String[] args){
        Human h1 = new Human();
        Student s1 = new Student();
        s1.eat();
    }
}
