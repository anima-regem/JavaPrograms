// Develop a program to find the largest and smallest word in a string.
import java.util.Scanner;

public class StringMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        String largest = arr[0];
        String smallest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > largest.length()) {
                largest = arr[i];
            }
            if (arr[i].length() < smallest.length()) {
                smallest = arr[i];
            }
        }
        System.out.println("Largest word: " + largest);
        System.out.println("Smallest word: " + smallest);
        sc.close();
    }
}
