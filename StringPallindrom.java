public class StringPallindrom {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abbca"));
    }
    private static Boolean isPalindrome(String input) {
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
