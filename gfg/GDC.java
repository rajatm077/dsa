package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Game of Death in a circle
 * https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle/0
 */

public class GDC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            String[] in = br.readLine().trim().split(" ");
            int n = Integer.parseInt(in[0]);
            int k = Integer.parseInt(in[1]);
        }
    }
}
