package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Leader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T -- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] in = br.readLine().trim().split(" ");
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(in[i]);
            }
            int crt_l = arr[arr.length - 1];
            Stack<Integer> al = new Stack<>();
            al.push(crt_l);
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] >= crt_l) {
                    crt_l = arr[i];
                    al.push(crt_l);
                }
            }
            StringBuffer sb = new StringBuffer();
            while (!al.isEmpty()) {
                sb.append(al.pop() + " ");
            }
            System.out.println(sb);
        }
    }
}