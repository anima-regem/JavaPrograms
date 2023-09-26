package Thread2;
import java.util.Random;

class RandomNumberGenerator extends Thread {
    @Override
    public void run() {
   	 Random random = new Random();
   	 while (true) {
   		 int randomNumber = random.nextInt(100) + 1;
   		 System.out.println("Generated Number: " + randomNumber);

   		 if (randomNumber % 2 == 0) {
       		 synchronized (EvenSquarePrinter.lock) {
           		 EvenSquarePrinter.number = randomNumber;
           		 EvenSquarePrinter.lock.notify();
       		 }
   		 } else {
       		 synchronized (OddCubePrinter.lock) {
           		 OddCubePrinter.number = randomNumber;
           		 OddCubePrinter.lock.notify();
       		 }
   		 }

   		 try {
       		 Thread.sleep(1000);
   		 } catch (InterruptedException e) {
       		 e.printStackTrace();
   		 }
   	 }
    }
}

class EvenSquarePrinter extends Thread {
    static final Object lock = new Object();
    static int number;

    @Override
    public void run() {
   	 while (true) {
   		 synchronized (lock) {
       		 try {
           		 lock.wait();
       		 } catch (InterruptedException e) {
           		 e.printStackTrace();
       		 }
       		 int square = number * number;
       		 System.out.println("Square of " + number + ": " + square);
   		 }
   	 }
    }
}

class OddCubePrinter extends Thread {
    static final Object lock = new Object();
    static int number;

    @Override
    public void run() {
   	 while (true) {
   		 synchronized (lock) {
       		 try {
           		 lock.wait();
       		 } catch (InterruptedException e) {
           		 e.printStackTrace();
       		 }
       		 int cube = number * number * number;
       		 System.out.println("Cube of " + number + ": " + cube);
   		 }
   	 }
    }
}

public class Main {
    public static void main(String[] args) {
   	 RandomNumberGenerator generatorThread = new RandomNumberGenerator();
   	 EvenSquarePrinter squareThread = new EvenSquarePrinter();
   	 OddCubePrinter cubeThread = new OddCubePrinter();

   	 generatorThread.start();
   	 squareThread.start();
   	 cubeThread.start();
    }
}

