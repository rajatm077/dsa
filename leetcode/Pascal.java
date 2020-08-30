package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  Pascal's Triangle II
 *  https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3234/
 */

public class Pascal {
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            List<Integer> l = getRow(i);
            System.out.println(l.toString());
        }
        System.out.println();
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int j = 0; j <=rowIndex; j++) {
            if (j == 0 || j == rowIndex) list.add(1);
             else {
                Integer val = cal(rowIndex-1, j-1, hm) + cal(rowIndex-1, j, hm);
                list.add(val);
            }
        }
        return list;
    }

    private static Integer cal(int i, int j, HashMap hm) {
        if (i < 2 || i == j || j == 0) return 1;
        else {
            Integer key = i * 100 + j;
            if (hm.containsKey(key)) return (Integer) hm.get(key);
            else {
                Integer res = cal(i-1, j-1, hm) + cal(i-1, j, hm);
                hm.put(key, res);
                return res;
            }
        }
    }
}
