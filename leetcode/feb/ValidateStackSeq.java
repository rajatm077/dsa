package leetcode.feb;

import java.util.Stack;

public class ValidateStackSeq {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[] {1,2,3,4,5 }, new int[] {4,3,5,1,2 }));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0, j = 0; i < popped.length; i++) {
            if (!stk.isEmpty() && stk.peek() == popped[i]) {
                stk.pop();
                continue;
            }

            if (j < pushed.length && pushed[j] == popped[i]) {
                j++;
                continue;
            }

            if (j >= pushed.length) return false;
            while (j < pushed.length && pushed[j] != popped[i]) {
                stk.push(pushed[j++]);
            }
            j++;
        }
        return stk.isEmpty();
    }
}
