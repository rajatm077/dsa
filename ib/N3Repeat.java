package ib;
import java.util.Arrays;
import java.util.List;

public class N3Repeat {
    // DO NOT MODIFY THE LIST
    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(1000938, 1000346, 1000346, 1000346, 1000561, 1000664, 1000671, 1000222, 1000702, 1000346, 1000346, 1000160, 1000958, 1000895);
        System.out.println(repeatedNumber(al));
    }
    public static int repeatedNumber(final List<Integer> a) {
        if (a.size() <= 2) {
            return a.get(0);
        }
        Integer slot1 = Integer.MAX_VALUE;
        Integer slot2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < a.size(); i ++) {
            Integer n = a.get(i);
            if (n.equals(slot1)) {
                count1 ++;
            } else if (n.equals(slot2)) {
                count2 ++;
            } else if (count1 == 0) {
                slot1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                slot2 = n;
                count2 = 1;
            } else {
                count1 --;
                count2 --;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < a.size(); i ++) {
            Integer n = a.get(i);
            if (n.equals(slot1)) {
                count1 ++;
            } else if (n.equals(slot2)) {
                count2 ++;
            }
        }
        if (count1 > a.size() / 3) {
            return slot1;
        }
        if (count2 > a.size() / 3) {
            return slot2;
        }
        return -1;
    }
}