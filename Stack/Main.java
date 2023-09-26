package Stack;
interface StackIface {
    void push(int element) throws FullException;
    int pop() throws EmptyException;
}


class FullException extends Exception {
    public FullException(String message) {
   	 super(message);
    }
}


class EmptyException extends Exception {
    public EmptyException(String message) {
   	 super(message);
    }
}


class Stack implements StackIface {
    private int[] stackArray;
    private int top;
    private int capacity;

    public Stack(int capacity) {
   	 this.capacity = capacity;
   	 stackArray = new int[capacity];
   	 top = -1;
    }

    @Override
    public void push(int element) throws FullException {
   	 if (top == capacity - 1) {
   		 throw new FullException("Stack is full. Cannot push element " + element + ".");
   	 }
   	 stackArray[++top] = element;
   	 System.out.println("Pushed element " + element + " onto the stack.");
    }

    @Override
    public int pop() throws EmptyException {
   	 if (top == -1) {
   		 throw new EmptyException("Stack is empty. Cannot pop element.");
   	 }
   	 int element = stackArray[top--];
   	 System.out.println("Popped element " + element + " from the stack.");
   	 return element;
    }
}


public class Main {
    public static void main(String[] args) {
   	 final int CAPACITY = 5;
   	 Stack stack = new Stack(CAPACITY);

   	 
   	 int choice;
   	 int element;

   	 while (true) {
   		 System.out.println("\n1. Push");
   		 System.out.println("2. Pop");
   		 System.out.println("3. Exit");
   		 System.out.print("Enter your choice (1/2/3): ");

   		 try {
       		 choice = Integer.parseInt(System.console().readLine());
       		 switch (choice) {
           		 case 1:
               		 System.out.print("Enter the element to push: ");
               		 element = Integer.parseInt(System.console().readLine());
               		 stack.push(element);
               		 break;
           		 case 2:
               		 element = stack.pop();
               		 break;
           		 case 3:
               		 System.out.println("Exiting the program.");
               		 return;
           		 default:
               		 System.out.println("Invalid choice. Please try again.");
       		 }
   		 } catch (NumberFormatException e) {
       		 System.out.println("Invalid input format. Please enter a valid integer.");
   		 } catch (FullException e) {
       		 System.out.println(e.getMessage());
   		 } catch (EmptyException e) {
       		 System.out.println(e.getMessage());
   		 }
   	 }
    }
}
