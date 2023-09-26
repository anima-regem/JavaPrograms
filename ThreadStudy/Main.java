package ThreadStudy;

class HelloThread extends Thread {
    @Override
    public void run() {
   	 while (true) {
   		 System.out.println("Hello");
   		 try {
       		 Thread.sleep(1000);
   		 } catch (InterruptedException e) {
       		 e.printStackTrace();
   		 }
   	 }
    }
}

class WorldRunnable implements Runnable {
    @Override
    public void run() {
   	 while (true) {
   		 System.out.println("World");
   		 try {
       		 Thread.sleep(3000);
   		 } catch (InterruptedException e) {
       		 e.printStackTrace();
   		 }
   	 }
    }
}

public class Main {
    public static void main(String[] args) {
   	 Thread helloThread = new HelloThread();
   	 Thread worldThread = new Thread(new WorldRunnable());

   	 helloThread.start();
   	 worldThread.start();
    }
}
