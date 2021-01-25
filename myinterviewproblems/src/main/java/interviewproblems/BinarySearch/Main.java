package interviewproblems.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,6,6,7};
        System.out.println(BinarySearch.binarySearch(arr, 6));

        int[] arr2 = {1,2,4,4,5,6,8};
        System.out.println(BinarySearch.indexInSortedList(arr2, 4));

        int [] arr3 = {1, 2, 4, 6};
        System.out.println(BinarySearch.indexElementOrClosest(arr3, 0));

        int [] arr4 = {4,5,1,2,3};
        System.out.println(BinarySearch.minCyclicallySortedArray(arr4));

        int [] arr5 = {1, 2, 4, 6, 8, 10, 15, 16};
        System.out.println(BinarySearch.binarySearchForUnknownLength(arr5, 10));

        System.out.println(BinarySearch.squareRootBinarySearch(3));

        int [] arr6 = {1,3,4,5,2};
        System.out.println(BinarySearch.findPeak(arr6));
    }
}
