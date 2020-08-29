package leetcode;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
        // PerfectSquare ps;
        // ps.hello();
    }

    public void hello() { System.out.println("hello"); }
    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        int max = num;
        int min = 0;
        int high = num;
        int low = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            long sqr = 1L * mid * mid;
            if (sqr == num) return true;
            if (sqr > num) {
                max = high;
                high = mid;
            } else {
                min = mid;
                break;
            }
        }
        
        for (int i = min; i <= max; i++) {
            long sqr = 1L * i * i;
            if (sqr == num) return true;
        }
        return false;
    }   
}