package leetcode;

import java.util.Arrays;

public class Judge {
    public static void main(String[] args) {
        int[][] trust = { { 1, 2}};//, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        System.out.println(findJudge(2, trust));
    }

    public static int findJudge(int N, int[][] trust) {
        int[] sol = new int[N];
        int index = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < trust.length; i++) {
            int t = trust[i][0] - 1;
            int l = trust[i][1] - 1; 
            sol[t] = -1;
            if (sol[l] != -1) {
                sol[l]++;
                if (sol[l] > max) {
                    max = sol[l];
                    index = i;
                }
            }
        }
        int val = sol[trust[index][1] - 1];
        if (val == N-1) return trust[index][1];
        else return -1;
    }
}