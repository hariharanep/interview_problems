package interviewproblems.ArraysAndStrings1;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[8];
        a[0] = 1;
        a[1] = 2;
        a[2] = 5;
        a[3] = 6;
        a[4] = 8;

        ReverseAndBothEndsTraversal.replaceEven(a);
        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();

        String temp = "I live in a house";
        temp = ReverseAndBothEndsTraversal.reverseWords(temp);
        System.out.println(temp);

        int[] arr = {1, 2, 3, 4, 5, 6};
        ReverseAndBothEndsTraversal.reverseElements(arr);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        int[] arr2 = {1,2,3,4,5};
        int[] result = ReverseAndBothEndsTraversal.twoSum(arr2, 9);
        if(result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println();

        int[] arr3 = {-4,-2,-1,0,3,5};
        int[] result2 = ReverseAndBothEndsTraversal.squaredOrder(arr3);
        if(result2 != null) {
            for (int i = 0; i < result2.length; i++) {
                System.out.print(result2[i] + " ");
            }
        }
        System.out.println();

        int[] arr4 = {1,3,5,2,6,4,7,8,9};
        int[] result3 = ReverseAndBothEndsTraversal.unsortedSubArray(arr4);
        if(result3 != null) {
            for (int i = 0; i < result3.length; i++) {
                System.out.print(result3[i] + " ");
            }
        }
        System.out.println();

        int[] arr5 = {4,2,0,1,0,3,0};
        PartitioningArrays.moveZeroesToBeginning(arr5);
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i] + " ");
        }
        System.out.println();

        int[] arr6 = {4,2,0,1,0,3,0};
        PartitioningArrays.moveZeroesToEnd(arr6);
        for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + " ");
        }
        System.out.println();

        int[] arr7 = {5,2,4,4,6,4,4,3};
        PartitioningArrays.partitionWithPivot(arr7, 4);
        for (int i = 0; i < arr7.length; i++) {
            System.out.print(arr7[i] + " ");
        }
        System.out.println();

        int[] arr8 = {1,0,1,2,1,0,1,2};
        try {
            PartitioningArrays.partitionMarbles(arr8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr8.length; i++) {
            System.out.print(arr8[i] + " ");
        }
        System.out.println();
    }
}
