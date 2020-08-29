package leetcode;

import java.util.HashMap;

public class Jewels {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("z", "ZZ"));

    }

    public static int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int count = 0;
        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        for (char c : j) {
            hm.put(c, 1);
        }
        for (char c : s) {
            if (hm.containsKey(c)) count++;
        }
        return count;
    }
}