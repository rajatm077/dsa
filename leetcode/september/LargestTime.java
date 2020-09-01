package leetcode.september;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/
 * Largest Time for Given Digits
 */

public class LargestTime {
    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{0, 2, 6, 6}));
    }

    public static String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        if (A[0] > 2) return "";
        if (A[A.length - 1] < 1) return "00:00";
        String res = "";
        for(int a: A) res += a;
        if (A[0] == A[3]) return res.substring(0, 2) + ":" + res.substring(3, 4);

        for (int i = 23; i >= 0; i--) {
            for (int j = 59; j >= 0; j--) {
                int[] arr = new int[] { 0 ,0, 0, 0};
                int i_t = i;
                int j_t = j;
                int k = 0;
                while (i_t > 0) {
                    arr[k++] = i_t % 10;
                    i_t /= 10;
                }

                while (j_t > 0) {
                    arr[k++] = j_t % 10;
                    j_t /= 10;
                }
                Arrays.sort(arr);
                String res2 = "";
                for(int a: arr) res2 += a;
                if (res.equals(res2)) {
                    String r = "" + i;
                    String rr = "" + j;
                    if (r.length() == 1) r = "0" + r;
                    if (rr.length() == 1) rr = "0" + rr;
                    return r + ":" + rr;
                }
            }
        }
        return "";
    }
}
