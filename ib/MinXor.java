package ib;

import java.util.Arrays;

public class MinXor {
    public static void main(String[] args) {
        System.out.println(minXor(new int[] { 15, 5, 1, 10, 2 }));

    }

    private static int minXor(int[] arr) {
        Arrays.sort(arr);
        int xor = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            xor = Math.min(xor, arr[i] ^ arr[i-1]);
        }
        return xor;
    }
}