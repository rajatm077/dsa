package leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
 */

public class ClimbingStairs {
    static HashMap<Integer, Long> hm = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(climbStairs(800));
    }
    public static Long climbStairs(int n) {
        if (n < 4) return Long.valueOf(n);
        else {
            if (hm.containsKey(n)) return hm.get(n);
            else {
                Long res = climbStairs(n-1) + climbStairs(n-2);
                hm.put(n, res);
                return res;
            }
        }
    }
}
