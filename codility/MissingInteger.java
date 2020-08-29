package codility;

import java.util.ArrayList;

public class MissingInteger {
    public static void main(String[] args) {
        int[] arr = { -1, -3 };
        System.out.println(missingInteger(arr));
    }

    private static int missingInteger(int[] A) {
        ArrayList<Integer> al = new ArrayList<>();
        boolean allneg = true; 
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                allneg = false;
                al.add(A[i]);
            }
        }
        if (allneg) return 1;
        for (int i = 0; i < al.size(); i++) {
            int v = al.get(i);
            if (v < 0) v = -v;
            if (v <= al.size()) {
                int k = al.get(v-1);
                if (k < 0) continue;
                k = -k;
                al.set(v-1, k);
            }
        }

        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) > 0) return (i + 1);
        }
        return al.size() + 1;
    }
}