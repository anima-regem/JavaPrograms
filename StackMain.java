/*
 program in Java to implement Stack operations using Class.
 */

import java.util.Scanner;

class Stack{
    int TOP=-1;
    int N=10;
    int[] STK = new int[N];

    boolean isEmpty(){
        return TOP==-1;
    }
    boolean isFull(){
        return TOP==N-1;
    }

    void push(int x){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        STK[++TOP]=x;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        return STK[TOP--];
    }
}

public class StackMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        int choice;
        do{
            System.out.println("Enter 1 to push, 2 to pop, 3 to exit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the element to be pushed");
                    int x = sc.nextInt();
                    s.push(x);
                    break;
                case 2:
                    System.out.println("Popped element is "+s.pop());
                    break;
                case 3:
                    System.exit(0);
            }
        }while(choice!=3);

        sc.close();

    }
}

/*

Enter 1 to push, 2 to pop, 3 to exit
1
Enter the element to be pushed
1
Enter 1 to push, 2 to pop, 3 to exit
1 
Enter the element to be pushed
2
Enter 1 to push, 2 to pop, 3 to exit
1
Enter the element to be pushed
3
Enter 1 to push, 2 to pop, 3 to exit
1
Enter the element to be pushed
4
Enter 1 to push, 2 to pop, 3 to exit
1
Enter the element to be pushed
5
Enter 1 to push, 2 to pop, 3 to exit
2
Popped element is 5
Enter 1 to push, 2 to pop, 3 to exit
2
Popped element is 4
Enter 1 to push, 2 to pop, 3 to exit
2
Popped element is 3
Enter 1 to push, 2 to pop, 3 to exit
2
Popped element is 2
Enter 1 to push, 2 to pop, 3 to exit
2
Popped element is 1
Enter 1 to push, 2 to pop, 3 to exit
2
Stack Underflow
Popped element is -1
Enter 1 to push, 2 to pop, 3 to exit
3s

 */