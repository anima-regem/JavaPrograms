
/*
NAME:MUNEERA A 
KTU-ID:PKD21IT042
*/
import java.util.Random;

class Square extends Thread {
    int x;

    Square(int n) {
        x = n;
    }

    public void run() {
        int sqr = x * x;
        System.out.println("Square of " + x + " = " + sqr);
    }
}

class Cube extends Thread {
    int x;

    Cube(int n) {
        x = n;
    }

    public void run() {
        int cub = x * x * x;
        System.out.println("Cube of " + x + " = " + cub);
    }
}

class Number extends Thread {
    public void run() {
        Random random = new Random();
        int randomInteger = random.nextInt(100);
        System.out.println("Random Integer generated : " + randomInteger);
        Cube c = new Cube(randomInteger);
        if (randomInteger % 2 != 0) {
            c.start();
        } else {
            Square s = new Square(randomInteger);
            s.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}

class Thr {
    public static void main(String args[]) {
        Number n = new Number();
        n.start();
    }
}
