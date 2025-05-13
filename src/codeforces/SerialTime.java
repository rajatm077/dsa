// https://codeforces.com/contest/60/problem/B
//package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SerialTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int m = Integer.parseInt(line[2]);
        char[][][] plate = new char[k][n][m];
        br.readLine();
        for (int t = 0; t < k; t++) {
            for (int r = 0; r < n; r++) {
                String row = br.readLine();
                for (int i = 0; i < row.length(); i++) {
                    plate[t][r][i] = row.charAt(i);
                }
            }
            br.readLine();
        }
        line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]) - 1;
        int y = Integer.parseInt(line[1]) - 1;
        int count = dfs(x, y, 0, plate);
        System.out.println(count);
    }

    private static int dfs(int row, int col, int z, char[][][] plate) {
        if (z < 0 || z >= plate.length ||
        row < 0 || row >= plate[z].length ||
        col < 0 || col >= plate[z][row].length ||
        plate[z][row][col] == '#' ||
        plate[z][row][col] == 'A') {
            return 0;
        }
        plate[z][row][col] = 'A';
        return 1 + dfs(row + 1, col, z, plate) +
        dfs(row - 1, col, z, plate) +
        dfs(row, col + 1, z, plate) +
        dfs(row, col - 1, z, plate) +
        dfs(row, col, z + 1, plate) +
        dfs(row, col, z - 1, plate);
    }
}

