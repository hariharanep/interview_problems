package interviewproblems.DynamicProgramming;

public class Main {
    public static void main(String[] args) {
        System.out.println(DPProblems.bottomUpNumWaysToTop(8));
        System.out.println(DPProblems.topDownNumWaysToTop(8));
        int[] arr = {1, 3, 2, 5, 3, 5, 6};
        System.out.println(DPProblems.longestIncreasingSubsequence(arr));
        int[] arr2 = {1, 2, 5};
        System.out.println(DPProblems.numCoinDenominations(arr2, 5));
    }
}
