// https://codeforces.com/contest/2037/problem/A
//package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Twice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N + 1];
            String[] in = br.readLine().split(" ");
            for (int i = 0; i < in.length; i++) {
                int index = Integer.parseInt(in[i]);
                arr[index]++;
            }
            int sol = 0;
            for (int i = 0; i < arr.length; i++) {
                sol += arr[i] / 2;
            }
            System.out.println(sol);
        }
    }
}

