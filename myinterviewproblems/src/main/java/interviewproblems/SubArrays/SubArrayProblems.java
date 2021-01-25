package interviewproblems.SubArrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayProblems {
    public static int[] subArraySumToTarget(int[] a, int target) {
        if (a == null || a.length == 0) {
            return null;
        }
        int startInd = -1;
        int endInd = -1;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == target) {
                startInd = 0;
                endInd = i;
                break;
            }
            if (map.containsValue(sum - target)) {
                startInd = map.get(sum - target) + 1;
                endInd = i;
                break;
            }
            map.put(sum, i);
        }
        if (startInd != -1 && endInd != -1) {
            int[] toReturn = new int[endInd - startInd + 1];
            int count = 0;
            for (int i = startInd; i <= endInd; i++) {
                toReturn[count] = a[i];
                count++;
            }
            return toReturn;
        }
        return null;
    }

    public static int[] subArraySumToZero(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int startInd = -1;
        int endInd = -1;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == 0) {
                startInd = 0;
                endInd = i;
                break;
            }
            if (map.containsValue(sum)) {
                startInd = map.get(sum) + 1;
                endInd = i;
                break;
            }
            map.put(sum, i);
        }
        if (startInd != -1 && endInd != -1) {
            int[] toReturn = new int[endInd - startInd + 1];
            int count = 0;
            for (int i = startInd; i <= endInd; i++) {
                toReturn[count] = a[i];
                count++;
            }
            return toReturn;
        }
        return null;
    }

    public static int[] longestUniqueCharSubstring(String a) {
        if (a == null || a.length() == 0) {
            return null;
        }
        int[] toReturn = new int[2];
        String largeSubstr;
        int largeBegin = 0;
        int largeEnd= 0;
        int start = 0;
        int end = 0;
        String currSubstring = a.substring(start, end + 1);
        largeSubstr = currSubstring;
        while (end < a.length() - 1) {
            end++;
            char newChar = a.charAt(end);
            int place = currSubstring.indexOf(newChar);
            if (place != -1) {
                start = start + place + 1;
            }
            currSubstring = a.substring(start, end + 1);
            if (currSubstring.length() > largeSubstr.length()) {
                largeBegin = start;
                largeEnd = end + 1;
                largeSubstr = currSubstring;
            }
        }
        toReturn[0] = largeBegin;
        toReturn[1] = largeEnd;
        if (largeSubstr.length() == 1) {
           toReturn[1]++;
        }
        return toReturn;
    }

    public static int maxSumSubArray(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int max = a[0];
        int currMaxEnding = a[0];
        for (int i = 1; i < a.length; i++) {
            currMaxEnding = max(a[i], a[i] + currMaxEnding);
            max = max(currMaxEnding, max);
        }
        return max;
    }

    public static int[] targetSumSubArray(int[] a, int target) {
        int[] toReturn = new int[2];
        if (a == null || a.length == 0) {
            toReturn[0] = -1;
            toReturn[1] = -1;
            return toReturn;
        }

        int start = 0;
        int end = 0;
        int sum = a[0];
        while (start < a.length) {
            if (end < start) {
                end = start;
                sum = a[start];
            }

            if (sum < target) {
                if (end >= a.length - 1) {
                    break;
                }
                end++;
                sum = sum + a[end];
            }
            else if (sum > target) {
                sum = sum - a[start];
                start++;
            }
            else {
                break;
            }
        }
        if (sum != target || start >= a.length) {
            toReturn[0] = -1;
            toReturn[1] = -1;
            return toReturn;
        }

        toReturn[0] = start;
        toReturn[1] = end;
        return toReturn;
    }

    private static int max(int i, int i1) {
        if (i > i1) {
            return i;
        }
        else {
            return i1;
        }
    }
}
