package interviewproblems.ArraysAndStrings1;

public class PartitioningArrays {
    public static void moveZeroesToBeginning(int[] a) {
        int boundary = 0;
        for(int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                int temp = a[i];
                a[i] = a[boundary];
                a[boundary] = temp;
                boundary++;
            }
        }
    }

    public static void moveZeroesToEnd(int[] a) {
        int boundary = a.length - 1;
        for(int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 0) {
                int temp = a[i];
                a[i] = a[boundary];
                a[boundary] = temp;
                boundary--;
            }
        }
    }

    public static void partitionWithPivot(int[] a, int target) {
        int boundary = a.length - 1;
        for(int i = a.length - 1; i >= 0; i--) {
            if (a[i] > target) {
                int temp = a[i];
                a[i] = a[boundary];
                a[boundary] = temp;
                boundary--;
            }
        }

        boundary = 0;
        for(int i = 0; i < a.length; i++) {
            if (a[i] < target) {
                int temp = a[i];
                a[i] = a[boundary];
                a[boundary] = temp;
                boundary++;
            }
        }
    }

    /*
    Given an array with n marbles colored Red, White or Blue,
    sort them so that marbles of the same color are adjacent,
    with the colors in the order Red, White and Blue. Assume the
    colors are given as numbers - 0 (Red), 1 (White) and 2 (Blue).
    For example, if A = [1,0,1,2,1,0,1,2], Output = [0,0,1,1,1,1,2,2].
     */
    public static void partitionMarbles(int[] a) throws Exception {
        int boundary = a.length - 1;
        for(int i = a.length - 1; i >= 0; i--) {
            if (a[i] != 0 && a[i] != 1 && a[i] != 2) {
                throw new Exception();
            }
            if (a[i] == 2) {
                int temp = a[i];
                a[i] = a[boundary];
                a[boundary] = temp;
                boundary--;
            }
        }

        boundary = 0;
        for(int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                int temp = a[i];
                a[i] = a[boundary];
                a[boundary] = temp;
                boundary++;
            }
        }
    }
}
