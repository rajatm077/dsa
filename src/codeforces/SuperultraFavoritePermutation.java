// https://codeforces.com/contest/2037/problem/C
//package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SuperultraFavoritePermutation {
    public static void main(String[] args) throws IOException {
        boolean[] primes = new boolean[200001];
        fillPrimes(primes);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n < 5) {
                System.out.println(-1);
                continue;
            }
            Set<Integer> toVisit = new HashSet<>();
            LinkedList<Integer> sol = new LinkedList<>();
            sol.add(1);
            for (int i = 2; i <= n; i++) {
                toVisit.add(i);
            }
            boolean hasPerm = findPerm(n, sol, toVisit, primes);
            if (hasPerm) {
                for (int i = 0; i < sol.size(); i++) {
                    System.out.print(sol.get(i) + " ");
                }
            } else {
                System.out.println(-1);
            }
        }
    }

    private static boolean findPerm(int n, LinkedList<Integer> sol, Set<Integer> toVisit, boolean[] primes) {
        if (sol.size() == n) {
            return true;
        }
        int current = sol.get(sol.size() - 1);
        Iterator<Integer> iterator = toVisit.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (!primes[current + next]) {
                sol.add(next);
                toVisit.remove(next);
                boolean hasPerm = findPerm(n, sol, toVisit, primes);
                if (hasPerm) {
                    return true;
                }
                sol.removeLast();
                toVisit.add(next);
            }
        }
        return false;
    }

    private static void fillPrimes(boolean[] primes) {
        Arrays.fill(primes, Boolean.TRUE);
        for (int i = 2; i < primes.length; i++) {
            for (int j = 2 * i; j < primes.length; j += i) {
                primes[j] = false;
            }
        }
    }
}

