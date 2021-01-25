package interviewproblems.BinarySearch;

public class BinarySearch {
    /*
    Returns first instance of element if there are duplicates
    in the input array
     */
    public static int binarySearch(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + ((end - start)/2);
            if (a[mid] > target) {
                end = mid - 1;
            }
            else if (a[mid] < target) {
                start = mid + 1;
            }
            else {
                if (mid == 0 || (mid - 1 >= 0 && a[mid - 1] != a[mid])) {
                    return mid;
                }
                else {
                    end = mid - 1;
                }

            }
        }

        return -1;
    }

    /*
     given a sorted array a and a target.
     Return the index where target would be placed if inserted in order.
     */
    public static int indexInSortedList(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        if (a.length == 0) {
            return 0;
        }
        if (target < a[0]) {
            return 0;
        }
        if (target >= a[a.length - 1]) {
            return a.length;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + ((end - start)/2);
            if (a[mid] <= target) {
                start = mid + 1;
            }
            else {
                if (mid - 1 >= 0 && a[mid - 1] <= target) {
                    return mid;
                }
                else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    /*
     Given a sorted array of Integers, find the target.
     If the target is not found,return the element closest to the target.
     */
    public static int indexElementOrClosest(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = a.length - 1;
        int result = Integer.MAX_VALUE;
        int result_index = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + ((end - start)/2);
            if (Math.abs(a[mid] - target) < Math.abs(result - target)) {
                result = a[mid];
                result_index = mid;
            }
            if (a[mid] > target) {
                end = mid - 1;
            }
            else if (a[mid] < target) {
                start = mid + 1;
            }
            else {
                if (mid == 0 || (mid - 1 >= 0 && a[mid - 1] != a[mid])) {
                    return mid;
                }
                else {
                    end = mid - 1;
                }

            }
        }
        return result_index;
    }

    /*
    Finds min of array that may or not be cyclically sorted
     */
    public static int minCyclicallySortedArray(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int start = 0;
        int end = a.length - 1;
        int pivot = a[a.length - 1];
        while (start <= pivot) {
            int mid = start + ((end - start)/2);
            if (a[mid] <= pivot && (mid == 0 || a[mid - 1] > a[mid])) {
                return mid;
            }
            else if (a[mid] > pivot) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /*
    Given a sorted array whose length is not known,
    perform binary search for a target T
     */
    public static int binarySearchForUnknownLength(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        int last_elem = 1;
        int lowerbound = -1;
        int higherbound = -1;
        try {
            while(true) {
                int temp = a[last_elem];
                last_elem = last_elem * 2;
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            lowerbound = last_elem/2;
            higherbound = last_elem;
        }
        last_elem = findLastIndex(a, lowerbound, higherbound);
        return binarySearchInRange(a, 0, last_elem, target);
    }

    public static int binarySearchInRange(int[] a, int start, int end, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }
        while (start <= end) {
            int mid = start + ((end - start)/2);
            if (a[mid] > target) {
                end = mid - 1;
            }
            else if (a[mid] < target) {
                start = mid + 1;
            }
            else {
                if (mid == 0 || (mid - 1 >= 0 && a[mid - 1] != a[mid])) {
                    return mid;
                }
                else {
                    end = mid - 1;
                }

            }
        }

        return -1;
    }

    public static int findLastIndex(int[] a, int l, int h) {
        while(l <= h) {
            int mid = l + ((h - l)/2);
            try {
                int temp = a[mid];
            }
            catch(ArrayIndexOutOfBoundsException e) {
                h = mid - 1;
                continue;
            }

            try {
                int temp = a[mid + 1];
            }
            catch(ArrayIndexOutOfBoundsException e) {
                return mid;
            }

            l = mid + 1;
        }
        return -1;
    }

    public static int squareRootBinarySearch(int num) {
        if (num < 0) {
            return -1;
        }
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int start = 0;
        int end = num/2;
        int mid = 0;
        while (start <= end) {
            mid = start + ((end - start)/2);
            if (mid*mid < num) {
                if ((mid + 1)*(mid + 1) >= num) {
                    return mid ;
                }
                start = mid + 1;
            }
            else if (mid*mid > num) {
                end = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static int findPeak(int[] a) {
        if(a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return a[0];
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + ((end - start)/2);
            if ((mid + 1 < a.length && a[mid] > a[mid + 1]) &&
                    (mid - 1 >= 0 && a[mid] > a[mid - 1])) {

                return mid;

            }
            else if (mid + 1 < a.length && a[mid] > a[mid + 1]) {
                if (mid == 0) {
                    return mid;
                }
                end = mid - 1;
            }
            else if (mid - 1 >= 0 && a[mid] > a[mid - 1]) {
                if (mid == a.length - 1) {
                    return mid;
                }
                start = mid + 1;
            }

        }
        return -1;
    }
}
