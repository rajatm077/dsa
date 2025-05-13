package misc;
public class SingleNumber2 {
    public static void main(String[] args) {
        int x = 12;
        x >>>= 1;
        System.out.println(x);
        System.out.println(single(new int[] { 1, 2, 4, 3, 3, 2, 2, 3, 1, 1 }));
        
    }

    private static int single(int[] arr) {
        int val = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            int start = (int) Math.pow(2, i);
            for (int j = 0; j < arr.length; j++) {
                int k2 = arr[j];
                int v2 = start & k2;
                if (v2 > 0) count++;
            }
            if (count % 3 != 0) {
                val += start;
            }
        }
        return val;
    }
}