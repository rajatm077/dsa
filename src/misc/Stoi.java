package misc;
public class Stoi {
    public static void main(String[] args) {
        System.out.println(convertStringToInteger("-1"));
        System.out.println(convertBase("615", 7, 13));
    }

    private static int convertStringToInteger(String input) {
        int result = 0;
        boolean isNegative = false;
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if (i == 0 && character == '-') {
                isNegative = true;
                continue;
            }
            if (character - '0' >= 0 && '9' - character < 10) {
                result = result * 10 + character - '0';
            }
        }
        if (isNegative) {
            result *= -1;
        }
        return result;
    }

    private static String convertBase(String numAsString, int b1, int b2) {
        boolean isNegative = numAsString.startsWith("-");
        int num = 0;
        for (int i = isNegative? 1: 0; i < numAsString.length(); i++) {
            num *= b1;
            num += Character.isDigit(numAsString.charAt(i)) ?
                    numAsString.charAt(i) - '0' :
                    numAsString.charAt(i) - 'A' + 10;
        }
        System.out.println(num);
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int remainder = num % b2;
            if (remainder > 9) {
                sb.append((char)('A' + remainder - 10));
            } else {
                sb.append((char)('0' + remainder));
            }
            num /= b2;
        }
        if (isNegative) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}
