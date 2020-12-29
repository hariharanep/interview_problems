package interviewproblems.BeginnerHashTableAndSorting;

import java.util.HashMap;
import java.util.Map;

public class HasDuplicates {
    public static boolean hasDuplicate(int[] a) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < a.length; i++) {
            if(map.size() == 0) {
                map.put(a[i], true);
            }
            else {
                if (map.containsKey(a[i]) ) {
                    return true;
                }
                else {
                    map.put(a[i], true);
                }
            }
        }
        return false;
    }
}