package leetcode.feb;

import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("word","good","best","good");
        System.out.println(findLongestWord("wordgoodgoodgoodbestword", list));
//        System.out.println(lexoSort("best", "good"));
    }
    public static String findLongestWord(String s, List<String> d) {
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hm.containsKey(c)) {
                ArrayList<Integer> al = new ArrayList<>();
                hm.put(c, al);
            }
            hm.get(c).add(i);
        }
        String sol = "";
        for (String in : d) {
            if (sol.length() > in.length()) continue;
            int crtIndex = -1;
            boolean tempSolFound = true;
            for (int i = 0; i < in.length(); i++) {
                boolean nextIndexFound = false;
                char crt = in.charAt(i);
                if (!hm.containsKey(crt)) {
                    tempSolFound = false;
                    break;
                }
                List<Integer> indices = hm.get(crt);
                for(Integer index: indices) {
                    if (index > crtIndex) {
                        crtIndex = index;
                        nextIndexFound = true;
                        break;
                    }
                }
                if (!nextIndexFound) {
                    tempSolFound = false;
                    break;
                }
            }
            if (tempSolFound) {
                if (sol.length() < in.length()) {
                    sol = in;
                } else {
                    sol = lexoSort(sol, in);
                }
            }
        }
        return sol;
    }

    private static String lexoSort(String sol, String in) {
        for (int i = 0; i < sol.length(); i++) {
            if (sol.charAt(i) == in.charAt(i)) {
                continue;
            } else if (sol.charAt(i) < in.charAt(i)) {
                break;
            } else {
                sol = in;
                break;
            }
        }
        return sol;
    }

}
