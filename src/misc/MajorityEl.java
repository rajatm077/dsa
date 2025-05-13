package misc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MajorityEl
 */
public class MajorityEl {
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

            int index = 0;
            int count = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] == arr[index]) {
                    count++;
                } else {
                    count--;
                }
                if (count <= 0) {
                    index = j;
                    count = 1;
                }
            }
            
            if (count < 1) {
                System.out.println(-1);
                continue;
            }
            int total = N >> 1;
            count = 0;
            boolean found = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[index]) {
                    count++;
                    if (count > total) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                System.out.println(arr[index]);
            } else {
                System.out.println(-1);
            }
        }
    }
}