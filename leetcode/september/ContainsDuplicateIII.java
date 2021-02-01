package leetcode.september;

import java.util.*;

/**
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/
 */
public class ContainsDuplicateIII {
    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[] {-1,2147483647}, 1, 2147483647));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long, ArrayList<Integer>> tm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (tm.containsKey(nums[i]*1l)) {
                tm.get(nums[i]).add(i);
            } else {
                tm.put(nums[i]*1l, new ArrayList<>(Arrays.asList(i)));
            }
        }

        for (Long key : tm.keySet()) {
            long diff = key + t;
            if (diff == key && tm.get(key).size() > 0) return true;
            ArrayList<Integer> i1 = tm.get(key);
            for (long i = 1; i <= diff; i++) {
                if (tm.containsKey(i)) {
                    ArrayList<Integer> indexes = tm.get(i);
                    for(int a = 0; a < i1.size(); a++) {
                        for (int b = 0; b < indexes.size(); b++) {
                            int diff2 = Math.abs(i1.get(a) - indexes.get(b));
                            if (diff2 <= k) return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
