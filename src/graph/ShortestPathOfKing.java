// https://codeforces.com/problemset/problem/3/A
//package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShortestPathOfKing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split("");
        String[] end = br.readLine().split("");
        int horizontal = (int) end[0].charAt(0) - (int) start[0].charAt(0);
        int vertical = (int) end[1].charAt(0) - (int) start[1].charAt(0);
        char h = horizontal > 0 ? 'R' : 'L';
        char v = vertical > 0 ? 'U': 'D';
        horizontal = Math.abs(horizontal);
        vertical = Math.abs(vertical);
        int sol = Math.max(horizontal, vertical);
        System.out.println(sol);
        for (int i = 0; i < sol; i++) {
            if (horizontal-- > 0) {
                System.out.print(h);
            }
            if (vertical-- > 0) {
                System.out.print(v);
            }
            System.out.println();
        }
    }
}
