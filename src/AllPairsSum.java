import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AllPairsSum {
    public static void main(String[] args) {
        int[] a = new int[] { 1,3 };
        System.out.println(minPatches(a, 7));
        int sr = 0, sc = 0, color = 0, srcColor = 0;
        System.out.println("sr: " + sr + ", sc: " + sc + ", color: " + color + ", srcColor: " + srcColor);
    }

    public static int minPatches(int[] nums, int n) {
        int[] sol = new int[n + 1];
        findAllPairsSum(nums, 0, 0, sol);
        System.out.println(Arrays.toString(sol));
        int patches = 0;
        for (int i = 1; i <= n; i++) {
            if (sol[i] == 0) {
                patches++;
                System.out.println(i);
                for (int j = n; j > 0; j--) {
                    if (sol[j] > 0 && j + i < sol.length) {
                        sol[j + i] = 1;
                    }
                }
                sol[i] = 1;
            }
        }
        return patches;
    }
    private static void findAllPairsSum(int[] a, int left, int sum, int[] sol) {
        if (left == a.length) {
            return;
        }
        sol[a[left]] = 1;
        for (int i = left; i < a.length; i++) {
            int currentSum = sum + a[i];
            sol[currentSum] = 1;
            findAllPairsSum(a, i + 1, currentSum, sol);
        }
    }
}
