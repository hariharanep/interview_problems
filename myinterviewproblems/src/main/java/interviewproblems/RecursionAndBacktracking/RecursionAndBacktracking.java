package interviewproblems.RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RecursionAndBacktracking {
    public static int fibonacciNthElement(int n) {
        if (n < 1) {
            return -1;
        }
        Map<Integer, Integer> fibonacciMap = new HashMap<Integer, Integer>();
        return fibonacci(n, fibonacciMap);
    }
    public static int fibonacci(int n, Map<Integer, Integer> fibonacciMap) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (fibonacciMap.containsKey(n)) {
            return fibonacciMap.get(n);
        }
        int result = fibonacci(n - 1, fibonacciMap) + fibonacci(n - 2, fibonacciMap);
        fibonacciMap.put(n, result);
        return result;
    }

    /*
    This function calculates x^n in O(log(n)) time
     */
    public static double exponent(double x, int n) {
        if (x == 0 && n <= 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return (x);
        }
        if (n < 0) {
            if (n % 2 == 0) {
                return exponent((1/x), n/2)*exponent((1/x), n/2);
            }
            else {
                return exponent((1/x), n/2)*exponent((1/x), n/2)*(1/x);
            }
        }

        if (n % 2 == 0) {
            return exponent(x, n/2)*exponent(x, n/2);
        }
        else {
            return exponent(x, n/2)*exponent(x, n/2)*x;
        }
    }

    /*
    Function prints all combinations of whatever length the buffer array in the
    2nd argument is. Order is not important here.
     */
    public static void printCombos(int[] a, int[] buffer, int startIndex, int bufferIndex) {
        //termination cases
        if (bufferIndex == buffer.length) {
            for (int i = 0; i < buffer.length; i++) {
                System.out.print(buffer[i] + " ");
            }
            System.out.println();
            return;
        }
        if (startIndex == a.length) {
            return;
        }

        //find candidates for current bufferIndex
        for (int i = startIndex; i < a.length; i++) {
            //place item in buffer
            buffer[bufferIndex] = a[i];

            //recursively move to next bufferIndex
            printCombos(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    /*
    Phone Number Mnemonic Problem: Given an N digit phone number,
    print all the strings that can be made from that phone number.
    Since 1 and 0 don't correspond to any characters, ignore them.
     */
    public static void phoneNumberMnemonicProblem(int[] a, char[] buffer, int startIndex, int bufferIndex) {
        if (startIndex == a.length || bufferIndex == buffer.length) {
            for (int i = 0; i < buffer.length; i++) {
                System.out.print(buffer[i] + " ");
            }
            System.out.println();
            return;
        }

        char[] letters = getLetters(a[startIndex]);
        if (letters.length == 0) {
            phoneNumberMnemonicProblem(a, buffer, startIndex + 1, bufferIndex);
        }
        for (int i = 0; i < letters.length; i++) {
            buffer[bufferIndex] = letters[i];

            phoneNumberMnemonicProblem(a, buffer, startIndex + 1, bufferIndex + 1);
        }
    }

    public static char[] getLetters(int n) {
        if (n == 2) {
            char[] letters = new char[3];
            letters[0] = 'A';
            letters[1] = 'B';
            letters[2] = 'C';
            return letters;
        }
        else if (n == 3) {
            char[] letters = new char[3];
            letters[0] = 'D';
            letters[1] = 'E';
            letters[2] = 'F';
            return letters;
        }
        else if (n == 4) {
            char[] letters = new char[3];
            letters[0] = 'G';
            letters[1] = 'H';
            letters[2] = 'I';
            return letters;
        }
        else if (n == 5) {
            char[] letters = new char[3];
            letters[0] = 'J';
            letters[1] = 'K';
            letters[2] = 'L';
            return letters;
        }
        else if (n == 6) {
            char[] letters = new char[3];
            letters[0] = 'M';
            letters[1] = 'N';
            letters[2] = 'O';
            return letters;
        }
        else if (n == 7) {
            char[] letters = new char[4];
            letters[0] = 'P';
            letters[1] = 'Q';
            letters[2] = 'R';
            letters[3] = 'S';
            return letters;
        }
        else if (n == 8) {
            char[] letters = new char[3];
            letters[0] = 'T';
            letters[1] = 'U';
            letters[2] = 'V';
            return letters;
        }
        else if (n == 9) {
            char[] letters = new char[4];
            letters[0] = 'W';
            letters[1] = 'X';
            letters[2] = 'Y';
            letters[3] = 'Z';
            return letters;
        }
        else {
            char[] letters = new char[0];
            return letters;
        }
    }

    public static void printAllSubsets(int[] a, int[] buffer, int startIndex, int bufferIndex) {
        for (int i = 0; i < bufferIndex; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();

        //termination cases
        if (bufferIndex == buffer.length) {
            return;
        }
        if (startIndex == a.length) {
            return;
        }

        //find candidates for current bufferIndex
        for (int i = startIndex; i < a.length; i++) {
            //place item in buffer
            buffer[bufferIndex] = a[i];

            //recursively move to next bufferIndex
            printAllSubsets(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    public static void printPermutations(int[] a, int[] buffer, int bufferIndex, boolean[] isInBuffer) {
        if (bufferIndex == buffer.length) {
            for (int i = 0; i < bufferIndex; i++) {
                System.out.print(buffer[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (isInBuffer[i] == false) {
                buffer[bufferIndex] = a[i];
                isInBuffer[i] = true;

                printPermutations(a, buffer, bufferIndex + 1, isInBuffer);
                isInBuffer[i] = false;
            }
        }
    }

    /*
    Given a set of coin denominations, print out the different ways
    you can make a target amount. You can use as many coins of each
    denomination as you like.
     */
    public static void coinDenominations(int[] a, Stack<Integer> buffer, int startIndex, int target) {
        if (sum(buffer) == target) {
            for (int i = 0; i < buffer.size(); i++) {
                System.out.print(buffer.get(i) + " ");
            }
            System.out.println();
            return;
        }
        if (sum(buffer) > target) {
            return;
        }

        for (int i = startIndex; i < a.length; i++) {
            buffer.push(a[i]);
            coinDenominations(a, buffer, startIndex, target);
            buffer.pop();
        }
    }

    public static int sum(Stack<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    /*
    You are given a 2D array that represents a maze.
    It can have 2 values - 0 and 1. 1 represents a wall and 0 represents a path.
    The objective is to reach the bottom right corner, i.e, A[A.length-1][A.length-1].
    You start fromA[0][0]. You can move in 4 directions - up, down, left and right.
    Find if a path exists to the bottom right of the maze.
     */
    public static boolean mazeProblem(int[][] a, int i, int j, boolean visited[][]) {
        if (a == null || a.length == 0) {
            return false;
        }
        if (a.length == 1) {
            return true;
        }
        if (i >= a.length || j >= a.length || i < 0 || j < 0 || a[i][j] == 1) {
            return false;
        }
        if (i == a.length - 1 && j == a[0].length - 1) {
            return true;
        }
        if (visited[i][j] == true) {
            return false;
        }
        visited[i][j] = true;
        int[] hori = {-1, 0, 0, 1};
        int[] verti = {0, 1, -1, 0};
        for (int b = 0; b < hori.length; b++) {
            if (mazeProblem(a, i + hori[b], j + verti[b], visited)) {
                return true;
            }
        }
        return false;
    }

    /*
    Given a String S, which contains letters and no spaces,
    find if it can be broken it into valid words. Return one
    such combination of words. Assume you are provided a dictionary of English words.
     */
    public static Stack<String> listOfWords(String i) {
        if (i == null || i.length() == 0) {
            return null;
        }
        Stack<String> currList = new Stack<String>();
        Stack<String> dictionnary = new Stack<String>();
        dictionnary.push("i");
        dictionnary.push("like");
        dictionnary.push("mango");
        dictionnary.push("tango");
        boolean visited[] = new boolean[i.length()];
        if (word_split(i, 0, currList, dictionnary, visited)) {
            return currList;
        }
        return null;
    }

    public static boolean word_split(String i, int startIndex, Stack<String> currList,
                                     Stack<String> dictionnary, boolean[] visited) {
        if (startIndex == i.length()) {
            return true;
        }
        if (visited[startIndex] == true) {
            return false;
        }

        for (int b = startIndex; b < i.length(); b++) {
            String word = i.substring(startIndex, b + 1);
            if (dictionnary.contains(word)) {
                currList.push(word);
                if (word_split(i, b + 1, currList, dictionnary, visited)) {
                    return true;
                }
                else {
                    currList.pop();
                    visited[b + 1] = true;
                }
            }
        }
        return false;
    }
}
