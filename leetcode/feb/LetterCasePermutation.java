package leetcode.feb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("abc"));
    }
    public static  List<String> letterCasePermutation(String S) {
        ArrayList<String> perms = new ArrayList<>();
        HashMap<String, Boolean> hm = new HashMap<>();
        getPermutation(S, hm, 0);
        perms.addAll(hm.keySet());
        return perms;
    }

    private static void getPermutation(String input, HashMap<String, Boolean> perms, int i) {
        if (i >= input.length()) return;
        if (!Character.isLetter(input.charAt(i))) {
            if (!perms.containsKey(input)) {
                perms.put(input, true);
            }
            getPermutation(input, perms, i+1);
            return;
        }
        char[] val = input.toCharArray();
        val[i] = Character.toUpperCase(val[i]);
        String perm1 = String.valueOf(val);
        if (!perms.containsKey(perm1)) {
            perms.put(perm1, true);
        }
        val[i] = Character.toLowerCase(val[i]);
        String perm2 = String.valueOf(val);
        if (!perms.containsKey(perm2)) {
            perms.put(perm2, true);
        }
        getPermutation(perm1, perms, i+1);
        getPermutation(perm2, perms, i+1);
        return;
    }
}
