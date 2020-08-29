package leetcode;


public class VersionControl {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
    
    public static boolean isBadVersion(int n) {
        // System.out.println(n - 1702766719);
        return n >= 1702766719;
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        if (isBadVersion(start))
            return start;
        
        int index = -1;
        while (start <= end) {
            int mid = ((end - start) / 2) + start;
            if (!isBadVersion(mid)) {
                start = mid + 1;
                continue;
            }
            index = mid;
            end = mid - 1;
        }
        return index;
    }
}