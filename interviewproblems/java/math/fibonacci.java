/******************************************************************************

 Online Java Compiler.
 Code, Compile, Run and Debug java program online.
 Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fibonacci {

    static Map<Integer, Integer> fibval = new HashMap<Integer, Integer> () ;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();
        System.out.println("Rec Answer = " + fibonacci_seq_recursive(n));
        System.out.println("Iterative Answer = " + fibonacci_seq_iterative(n));
        System.out.println("Hash Method Storage = " + fibonacci_hash(n));
        System.out.println("Matrix Log Method = " + fib(n));
    }

    public static int fibonacci_seq_iterative(int n) {
        if (n == 1 ) {
            return 1;
        }
        else if (n == 2) {
            return 1;
        }
        int num = 1;
        int num2 = 1;
	int sum = 0 ;
        for (int i = 3; i <= n; i++) {
	    sum = num + num2;
            num = num2;
            num2 = sum;
        }
        return sum;
    }

    public static int fibonacci_seq_recursive(int n) {
        if(n <= 2){
            return 1;
        }
        return (fibonacci_seq_recursive(n-1) + fibonacci_seq_recursive(n-2));
    }

    public static int fibonacci_hash (int n) {
        if (fibval.size() == 0){
            fibval.put(0, 1) ;
            fibval.put(1, 1) ;
            fibval.put(2, 1) ;
        }

        for (int i = 3 ; i <= n ; i++) {
            fibval.put(i, fibval.get(i-1)+fibval.get(i-2)) ;
        }
        return fibval.get(n);
    }

    public static int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n <= 2) return 1 ;
        int [][] F = new int[][]{{1,1} , {1,0}} ;
        power(F, n-1);
        return F[0][0] ;
    }

    public static void multiply (int [][]F, int [][] M) {
        int[][] N = new int[F.length][F[0].length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                N[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    N[i][j] += F[i][k]*M[k][j];
                }
            }
        }
        for (int i = 0 ; i < F.length ; i++){
            for (int j = 0 ; j < F[0].length ; j++) {
                F[i][j] = N[i][j] ;
            }
        }
    }

    public static void power(int[][] F, int n) {
         if (n == 0 || n ==1) return ;
        power (F, n/2) ;
        multiply (F, F) ;
        if ((n % 2) == 1) {
            int[][] M = new int[][]{{1,1} , {1,0}} ;
            multiply (F, M) ;
        }
    }
}
