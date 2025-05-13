package misc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T -- > 0) {
            String[] in = br.readLine().trim().split(" ");
            int N = Integer.parseInt(in[0]);
            Long S = Long.parseLong(in[1]);
            in = br.readLine().trim().split(" ");
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(in[i]);
            }
            int start = 0;
            long sum = 0;
            boolean found = false;
            int end = 0;
            for (end = 0; end < arr.length; end++) {
                sum += arr[end];
                if (sum == S) break;
                while (sum > S) {
                    sum -= arr[start];
                    start++;
                }
                if (sum == S) break;
            }
            found = S == sum;
            if (found) {
                System.out.println(++start + " " + ++end);
            } else {
                System.out.println(-1);
            }
        }
    }
}