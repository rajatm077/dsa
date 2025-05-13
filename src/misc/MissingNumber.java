package misc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] in = br.readLine().trim().split(" ");
            long sum = 0;
            for (int i = 0; i < in.length; i++) {
                sum += Integer.parseInt(in[i]);
            }
            long total = 0;
            if ((N & 1) == 0) {
                total = (N >> 1) * (N + 1);
            } else {
                total = ((N + 1) >> 1) * N;
            }
            int missing = (int) (total - sum);
            System.out.println(missing);
        }
    }
}