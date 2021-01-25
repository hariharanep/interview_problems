package interviewproblems.ArraysAndStrings1;

//Assumes that the array has enough space to accommodate the result.
//Assumes that we shouldn't allocate another temp array in the solution
public class ReverseAndBothEndsTraversal {
    public static void replaceEven(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int i = 0;
        for (int j = a.length - 1; j >= 0; j--) {
            if (a[j] != 0) {
                i = j;
                break;
            }
        }
        int end = a.length - 1;

        while (i >= 0) {
            if(a[i] % 2 == 0){
                a[end] = a[i];
                end--;
                a[end] = a[i];
                end--;
            }
            else {
                a[end] = a[i];
                end--;
            }
            i--;
        }

    }

    public static String reverseWords(String a) {
        String temp = "";
        if (a == null || a.length() == 0) {
            return "";
        }
        int i = a.length() - 1;
        int word_count = 0;
        while (i >= 0) {
            String word = "";
            while(i >= 0 && a.charAt(i) != ' '){
                word = a.charAt(i) + word;
                i--;
            }
            if (word_count == 0) {
                temp = temp + word;
            }
            else {
                temp = temp + " " + word;
            }
            word_count++;
            i--;
        }
        return temp;
    }

    public static void reverseElements(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }

    public static int[] twoSum(int[] a, int sum) {
        int[] result  = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (a == null || a.length == 0 || a.length == 1) {
            return null;
        }
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            if (a[start] + a[end] > sum) {
                end--;
            }
            else if (a[start] + a[end] < sum) {
                start++;
            }
            else {
                result[0] = a[start];
                result[1] = a[end];
                break;
            }
        }
        if (result[0] == -1 && result[1] == -1) {
            return null;
        }
        else {
            return result;
        }
    }

    public static int[] squaredOrder(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] toReturn = new int[a.length];
        int start = 0;
        int end = a.length - 1;
        int count = 0;
        while(start <= end) {
            int absValStart = a[start];
            int absValEnd = a[end];
            if (a[start] < 0) {
                absValStart = -1*a[start];
            }
            if (a[end] < 0) {
                absValEnd = -1*a[end];
            }
            int squaredStart = absValStart * absValStart;
            int squaredEnd = absValEnd * absValEnd;
            if (absValEnd > absValStart) {
                toReturn[count] = squaredEnd;
                end--;
            }
            else {
                toReturn[count] = squaredStart;
                start++;
            }
            count++;
        }
        reverseElements(toReturn);
        return toReturn;
    }

    public static int[] unsortedSubArray(int[] a) {
        int start = -1;
        int end = -1;
        for (int i = 0; i < a.length; i++) {
            if (i + 1 < a.length && a[i] > a[i + 1]) {
                start = i ;
                break;
            }
        }
        for (int i = a.length - 1; i >= 0; i--) {
            if (i - 1 >= 0 && a[i] < a[i - 1]) {
                end = i;
                break;
            }
        }
        int maxSubArray = max(start, end, a);
        int minSubArray = min(start, end, a);

        for (int i = 0; i < start; i++) {
            if (a[i] > minSubArray && a[i] < maxSubArray) {
                start = i;
            }
        }

        for (int i = a.length - 1; i > end; i--) {
            if (a[i] > minSubArray && a[i] < maxSubArray) {
                end = i;
            }
        }


        int[] toReturn = new int[end - start + 1];
        for (int i = 0; i < toReturn.length; i++) {
            toReturn[i] = a[i + start];
        }

        return toReturn;
    }

    public static int max(int start, int end, int[] a){
        int max = a[start];
        for (int i = start; i <= end; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int min(int start, int end, int[] a){
        int min = a[start];
        for (int i = start; i <= end; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
}
