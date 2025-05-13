// https://codeforces.com/contest/727/problem/A

//package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Transformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        transform(Integer.valueOf(input[0]), Integer.valueOf(input[1]), new ArrayList<>());
    }

    private static void transform(int start, int end, List<Integer> seq) {
        if (start > end) {
            System.out.println("NO");
            return;
        }
        seq.add(end);
        if (start == end) {
            System.out.println("YES");
            System.out.println(seq.size());
            for (int i = seq.size() - 1; i >= 0; i--) {
                System.out.print(seq.get(i) + " ");
            }
            return;
        }
        if (end % 2 == 0) {
            end = end / 2;
            transform(start, end, seq);
            return;
        }
        if (end % 10 == 1) {
            end = end / 10;
            transform(start, end, seq);
            return;
        }
        System.out.println("NO");
        return;
    }
}
