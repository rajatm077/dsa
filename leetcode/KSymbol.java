package leetcode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675/
 * K-th Symbol in Grammar
 *
 */
public class KSymbol {
    public static void main(String[] args) {
        System.out.println(kthGrammar(4,5));
    }
    public static int kthGrammar(int i, int j) {
        if (i == 1 || j == 1) return 0;
        if (j == (int) Math.pow(2, i-1)) return 1 ^ (i % 2);
        int temp = kthGrammar(i-1, (j+1)/2);
        if (j % 2 != 0) return temp;
        else return temp ^= 1;
    }
}
