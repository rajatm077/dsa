// https://codeforces.com/contest/2037/problem/B
//package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class InterceptedInputs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine()) - 2;
            String[] in = br.readLine().split(" ");
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < in.length; i++) {
                int val = Integer.parseInt(in[i]);
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            for (int i = 0; i < in.length; i++) {
                int n = Integer.parseInt(in[i]);
                if (n > k) {
                    continue;
                }
                map.put(n, map.get(n) - 1);
                int m = k/n;
                int r = k % n;
                if (r == 0 && map.getOrDefault(m, 0) > 0) {
                    System.out.println(n + " " + m);
                    break;
                }
                map.put(n, map.get(n) + 1);
            }

        }
    }
}

