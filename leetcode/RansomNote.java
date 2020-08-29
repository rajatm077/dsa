package leetcode;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "b"));
        
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] mag = magazine.toCharArray();
        char[] note = ransomNote.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : mag) {
            if (hm.containsKey(c)) {
                int count = hm.get(c);
                hm.put(c, ++count);
            } else {
                hm.put(c, 1);
            }
        }
        for (char c : note) {
            if (!hm.containsKey(c)) return false;
            int val = hm.get(c);
            if (val == 0) return false;
            else {
                hm.put(c, --val);
            }
        }
        return true;
    } 
}