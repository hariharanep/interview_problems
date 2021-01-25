package interviewproblems.DynamicProgramming;

public class DPProblems {

    /*
    Let’s say you have to climb n steps. You can jump 1 step, 3 steps or 5 steps at a time.
     How many ways are there to get to the top of the steps?
     */
    public static int bottomUpNumWaysToTop(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                arr[i + 1] = arr[i + 1] + arr[i];
            }
            if (i + 3 < arr.length) {
                arr[i + 3] = arr[i + 3] + arr[i];
            }
            if (i + 5 < arr.length) {
                arr[i + 5] = arr[i + 5] + arr[i];
            }
        }
        return arr[n];
    }

    /*
    Let’s say you have to climb n steps. You can jump 1 step, 3 steps or 5 steps at a time.
     How many ways are there to get to the top of the steps?
     */
    public static int topDownNumWaysToTop(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i - 1 >= 0) {
                arr[i] += arr[i - 1];
            }
            if (i - 3 >= 0) {
                arr[i] += arr[i - 3];
            }
            if (i - 5 >= 0) {
                arr[i] += arr[i - 5];
            }
        }
        return arr[n];
    }

    /*
    Given an array of integers, find the length of the longest increasing subsequence.
    For e.g, in [1, 3, 2, 5, 3, 5, 6], the longest increasing subsequence is [1, 2, 3, 5, 6] of length 5.
     */
    public static int longestIncreasingSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 1;
        }
        int max = 0;
        int lis[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = max(lis[i], lis[j] + 1);
                }
            }
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }

    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    /*
    Given a set of coin denominations, print out the number of ways you can make a target amount.
    You can use as many coins of each denomination as you like.
     */
    public static int numCoinDenominations(int[] coins, int target) {
        if (coins == null || coins.length == 0 || target <= 0) {
            return -1;
        }
        int[] arr = new int[target + 1];
        arr[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j + coins[i] < arr.length) {
                    arr[j + coins[i]] += arr[j];
                }
            }

        }

        return arr[target];
    }


}
