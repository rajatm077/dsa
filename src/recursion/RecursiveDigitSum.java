// https://www.hackerrank.com/challenges/recursive-digit-sum/problem

package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int sol = recursiveDigitSum(input[0], Integer.valueOf(input[1]));
        System.out.println(sol);
    }

    private static int recursiveDigitSum(String number, Integer k) {
        int sum = Integer.parseInt(getSum(number));
        sum = sum * k;
        return Integer.parseInt(getSum(String.valueOf(sum)));
    }

    private static String getSum(String number) {
        if (number.length() == 1) {
            return number;
        }
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
        }
        return getSum(String.valueOf(sum));
    }
}
