package interviewproblems.RecursionAndBacktracking;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(RecursionAndBacktracking.fibonacciNthElement(5));

        System.out.println(RecursionAndBacktracking.exponent(-2, 3));

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] buffer  = new int[3];
        RecursionAndBacktracking.printCombos(arr, buffer, 0, 0);

        int[] arr2 = {4, 5, 6};
        char[] buffer2 = new char[3];
        RecursionAndBacktracking.phoneNumberMnemonicProblem(arr2, buffer2, 0, 0);

        int[] arr3 = {1, 2, 3};
        int[] buffer3  = new int[3];
        RecursionAndBacktracking.printAllSubsets(arr3, buffer3, 0, 0);

        int[] arr4 = {1, 2, 3, 4, 5, 6, 7};
        int[] buffer4  = new int[3];
        boolean[] isInBuffer = new boolean[arr4.length];
        RecursionAndBacktracking.printPermutations(arr4, buffer4, 0, isInBuffer);

        int[] arr5 = {1, 2, 5};
        Stack<Integer> buffer5 = new Stack<>();
        RecursionAndBacktracking.coinDenominations(arr5, buffer5, 0, 5);

        int[][] arr6 = {{0,1,1,1},{0,1,1,1},{0,0,0,0},{1,1,1,0}};
        boolean[][] visited = new boolean[arr6.length][arr6[0].length];
        System.out.println(RecursionAndBacktracking.mazeProblem(arr6, 0, 0, visited));

        Stack<String> temp = RecursionAndBacktracking.listOfWords("ilikemangotango");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }

    }
}
