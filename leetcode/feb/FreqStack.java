package leetcode.feb;

import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    int max_freq;
    HashMap<Integer, Stack<Integer>> stkMap;
    HashMap<Integer, Integer> freqMap;
    public FreqStack() {
        max_freq = 0;
        stkMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void push(int x) {
        int freq = 0;
        if (freqMap.containsKey(x)) {
            freq = freqMap.get(x);
        }
        freqMap.put(x, freqMap.getOrDefault(x, freq++) + 1);
        max_freq = Math.max(max_freq, freq);
        Stack<Integer> stk;
        if (stkMap.containsKey(freq)) {
            stk = stkMap.get(freq);
        } else {
            stk = new Stack<>();
            stkMap.put(freq, stk);
        }
        stk.push(x);
    }

    public int pop() {
        Stack<Integer> fstk = stkMap.get(max_freq);
        if (fstk.size() == 1) {
            max_freq--;
        }
        int x = fstk.pop();
        freqMap.replace(x, freqMap.get(x) - 1);
        return x;
    }

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        int[] stkElements = new int[] { 4,0,9,3,4,2 };
        for (int i = 0; i < stkElements.length; i++) {
            stack.push(stkElements[i]);
        }
        System.out.println(stack.pop());
        stack.push(6);
        System.out.println(stack.pop());
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(4);
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop());
        }


    }
}




/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */