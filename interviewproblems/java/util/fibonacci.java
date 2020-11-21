/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();
        System.out.println(fibonacci_seq_recursive(n));
        System.out.println(fibonacci_seq_iterative(n));
    }
    public static int fibonacci_seq_iterative(int n) {
        if (n == 1 ) {
            return 1;
        }
        else if (n == 2) {
            return 1;
        }
        int num = 0;
        int num2 = 1;
        for (int i = 1; i <= n; i++) {
            int sum = num + num2;
            num = num2;
            num2 = sum;
        }
        return num;
    }

    public static int fibonacci_seq_recursive(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacci_seq_recursive(n-1) + fibonacci_seq_recursive(n-2);

    }
}
