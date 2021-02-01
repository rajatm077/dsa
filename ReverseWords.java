public class ReverseWords {
    public static void main(String[] args) {
        char[] input = "Alice likes Bob".toCharArray();
        System.out.println(reverseWords(input));
    }

    private static String reverseWords(char[] input) {
        reverse(input, 0, input.length - 1);

        int start = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                reverse(input, start, i-1);
                start = i + 1;
            }
        }
        reverse(input, start, input.length - 1);
        return String.valueOf(input);
    }

    private static void reverse(char[] input, int start, int end) {
        while (start < end) {
            char temp = input[start];
            input[start++] = input[end];
            input[end--] = temp;
        }
    }
}
