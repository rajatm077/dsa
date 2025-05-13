package leetcode.feb;
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(4));
        System.out.println(hammingWeight(-3));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
