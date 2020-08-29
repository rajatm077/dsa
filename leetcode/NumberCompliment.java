package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberCompliment {
    public static void main(String[] args) {
        System.out.println(findComplement(2));
    }

    public static int findComplement(int num) {
        Queue<Integer> q = new LinkedList<>();
        
        while (num > 0) {
            int val = num % 2;
            q.add(val);
            num >>= 1;
        }
        
        int res = 0;
        int i = 0;
        while (!q.isEmpty()) {
            int val = q.remove() ^ 1;
            res += (int) Math.pow(2, i) * val;
            i++;
        }
        return res;
    }
}