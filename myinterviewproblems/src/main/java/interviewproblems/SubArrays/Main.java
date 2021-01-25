package interviewproblems.SubArrays;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -1};
        System.out.println(SubArrayProblems.maxSumSubArray(arr1));

        int[] arr2 = {1,2,3,5,2};
        int[] arr3 = SubArrayProblems.targetSumSubArray(arr2, 6);
        for(int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        //String temp = "whatwhywhere";
        String temp = "askjhnmbp";
        if (SubArrayProblems.longestUniqueCharSubstring(temp) != null) {
            int[] arr4 = SubArrayProblems.longestUniqueCharSubstring(temp);
            for(int i = 0; i < arr4.length; i++) {
                System.out.print(arr4[i] + " ");
            }
            System.out.println(temp.substring(arr4[0], arr4[1]));
        }

        int[] arr5 = {2,4,-2,1,-3,5,-3};
        //int[] arr5 = {1, 1};
        int[] arr6 = SubArrayProblems.subArraySumToZero(arr5);
        if (arr6 != null) {
            for (int i = 0; i < arr6.length; i++) {
                System.out.print(arr6[i] + " ");
            }
            System.out.println();
        }

        int[] arr7 = {2,4,-2,1,-3,5,-3};
        //int[] arr7 = {1, 1, 2, -3};
        int[] arr8 = SubArrayProblems.subArraySumToTarget(arr7, 5);
        if (arr8 != null) {
            for (int i = 0; i < arr8.length; i++) {
                System.out.print(arr8[i] + " ");
            }
            System.out.println();
        }

    }
}
