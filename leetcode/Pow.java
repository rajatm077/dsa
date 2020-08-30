package leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
 * Pow(x,n)
 */
public class Pow {
    HashMap<Integer, Double> hm = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (x == 1.0) return 1.0;
        if (x == 0.0) return 0.0;
        if (n == 0) return 1.0;
        double res = 1;
        for (int i = 1; i <= Math.abs(n); i++) {
            res *= x;
            if (res == 0) return res;
        }
        if (n < 0) res = 1/res;
        return res;
    }

    public double calc(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (hm.containsKey(n)) return hm.get(n);
        else {
            double res = calc(x, n/2); // * calc(x, n - n/2);
            res = res * calc(x, n-n/2);
            hm.put(n, res);
            return res;
        }

    }
}
