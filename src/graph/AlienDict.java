package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDict {
    public static void main(String[] args) {
        String[] str = new String[]  { "a", "aaabb", "bba", "babb", "a", "aba", "aaab", "aba", "a", "bbbb" };
        System.out.println(findOrder(str, 2));
    }
    public static String findOrder(String[] dict, int k) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize each row
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < dict.length; i++) {
            char[] prev = dict[i - 1].toCharArray();
            char[] current = dict[i].toCharArray();
            for (int j = 0; j < prev.length && j < current.length; j++) {
                if (prev[j] != current[j]) {
                    int index = prev[j] - 'a';
                    int value = current[j] - 'a';
                    adj.get(index).add(value);
                    break;
                }
            }
        }

        System.out.println(adj);
        int[] indegree = new int[k];
        for (int i = 0; i < adj.size(); i++) {
            List<Integer> vertices = adj.get(i);
            for (int j = 0; j < vertices.size(); j++) {
                indegree[vertices.get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append((char) ('a' + current));

            List<Integer> vertices = adj.get(current);
            if (vertices == null) {
                continue;
            }
            for (int i = 0; i < vertices.size(); i++) {
                indegree[vertices.get(i)]--;
                if (indegree[vertices.get(i)] == 0) {
                    q.offer(vertices.get(i));
                }
            }
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) {
                return "";
            }
        }
        return sb.toString();
    }
}