package interviewproblems.BeginnerHashTableAndSorting;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static boolean doesSumExist(int[] a, int num) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], true);
        }
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(num - a[i])) {
                return true;
            }
        }
        return false;
    }
}
