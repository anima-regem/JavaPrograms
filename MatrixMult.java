//  Java program for matrix multiplication.(Check the order of the matrices before multiplication, Only main function needed)

import java.util.Scanner;

public class MatrixMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the first matrix: ");
        int m1 = sc.nextInt();
        int n1 = sc.nextInt();
        System.out.println("Enter the number of rows and columns of the second matrix: ");
        int m2 = sc.nextInt();
        int n2 = sc.nextInt();
        if (n1 != m2) {
            System.out.println("Multiplication is not possible");
        }
        int[][] a = new int[m1][n1];
        int[][] b = new int[m2][n2];
        System.out.println("Enter the elements of the first matrix: ");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of the second matrix: ");
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        if (n1 == m2) {
            int[][] c = new int[m1][n2];
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    for (int k = 0; k < n1; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

            System.out.println("The product of the matrices is: ");
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Operation not possible");
        }

        sc.close();
    }
}

/*

Enter the number of rows and columns of the first matrix: 
2
2
Enter the number of rows and columns of the second matrix: 
2
2
Enter the elements of the first matrix: 
2
2
2
2
Enter the elements of the second matrix: 
2
2
2
2
The product of the matrices is: 
8 8 
8 8

 */