import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.pop();
        System.out.println(stk.size());
    }
}