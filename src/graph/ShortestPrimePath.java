package graph;
import java.util.BitSet;

public class ShortestPrimePath {
    public static void main(String[] args) {
        int upperLimit = 10000;
        BitSet sieve = sieveOfEratosthenes(upperLimit);

        // Print primes between 1000 and 10000
        System.out.println("Prime numbers between 1000 and 10000:");
        System.out.println(sieve.cardinality());
        for (int i = 1000; i <= upperLimit; i++) {
            if (sieve.get(i)) {
                System.out.print(i + " ");
            }
        }
    }

    // Sieve of Eratosthenes using BitSet
    private static BitSet sieveOfEratosthenes(int upperLimit) {
        BitSet sieve = new BitSet(upperLimit + 1);
        sieve.set(2, upperLimit + 1);  // Assume all numbers are prime initially

        for (int i = 2; i * i <= upperLimit; i++) {
            if (sieve.get(i)) {
                for (int j = i * i; j <= upperLimit; j += i) {
                    sieve.clear(j);  // Mark multiples of i as non-prime
                }
            }
        }

        return sieve;
    }
}
