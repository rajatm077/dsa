package leetcode.april;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String str: strs) {
            char[] temp_char = str.toCharArray();
            Arrays.sort(temp_char);
            String temp_str = String.valueOf(temp_char);
            if (hm.containsKey(temp_str)) {
                ArrayList<String> grp = hm.get(temp_str);
                grp.add(str);
            } else {
                ArrayList<String> grp = new ArrayList<>();
                grp.add(str);
                hm.put(temp_str, grp);
            }
        }
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            res.add(hm.get(key));
        }
        System.out.println(res.toString());
    }
}
