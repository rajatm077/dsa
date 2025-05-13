package misc;
public class Pallindrom2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Ray a Ray"));
    }

    private static boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        input = input.toLowerCase();
        while (left < right) {
            char leftChar = input.charAt(left);
            if (leftChar < 'a' || leftChar > 'z') {
                left++;
                continue;
            }
            char rightChar = input.charAt(right);
            if (rightChar < 'a' || rightChar > 'z') {
                right--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
