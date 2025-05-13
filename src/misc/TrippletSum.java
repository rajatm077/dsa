package misc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TrippletSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T -- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] in = br.readLine().trim().split(" ");
            int[] arr = new int[N];
            int largest = Integer.MIN_VALUE;
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(in[i]);
                if (arr[i] > largest) largest = arr[i];
                hm.put(arr[i], arr[i]);
            }
            int count = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == largest) continue;
                for (int j = 1; j < arr.length; j++) {
                    int sum = arr[i] + arr[j];
                    if (hm.containsKey(sum)) count++;
                }
            }
            if (count > 0) System.out.println(count);
            else System.out.println(-1);
        }
    }
}