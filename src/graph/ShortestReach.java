// https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
// Accepted
package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestReach {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] in = br.readLine().split(" ");
            int nodes = Integer.parseInt(in[0]);
            int edges = Integer.parseInt(in[1]);
            Map<Integer, List<Integer>> adj = new HashMap<>();
            int[] visited = new int[nodes + 1];
            for (int e = 0; e < edges; e++) {
                in = br.readLine().split(" ");
                int u = Integer.parseInt(in[0]);
                int v = Integer.parseInt(in[1]);
                addInAdjacenyList(u, v, adj);
            }
            int source = Integer.parseInt(br.readLine());
            bfs(source, visited, adj);
            printTree(source, visited);
        }
    }

    private static void printTree(int source, int[] visited) {
        for (int i = 1; i < visited.length; i++) {
            if (i == source) {
                continue;
            }
            if (visited[i] == 0) {
                System.out.print("-1 ");
            } else {
                System.out.print(visited[i] + " ");
            }
        }
        System.out.println();
    }

    private static void bfs(int source, int[] visited, Map<Integer, List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            List<Integer> neighbours = adj.get(current);
            if (neighbours == null) {
                continue;
            }
            for (int neighbour : neighbours) {
                if (visited[neighbour] == 0 && neighbour != source) {
                    q.add(neighbour);
                    visited[neighbour] = visited[current] + 6;
                }
            }
        }
    }

    private static void addInAdjacenyList(int u, int v, Map<Integer, List<Integer>> adj) {
        List<Integer> nodes = adj.getOrDefault(u, new ArrayList<>());
        nodes.add(v);
        adj.put(u, nodes);
        nodes = adj.getOrDefault(v, new ArrayList<>());
        nodes.add(u);
        adj.put(v, nodes);
    }
}
