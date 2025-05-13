package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Groups {
    public static void main(String[] args) throws IOException {
        int[] groups = new int[] { -1,-1,1,0,0,1,0,-1 };
        int[][] bf = {
                {},{6},{5},{6},{3,6},{},{},{}
        };
        List<List<Integer>> beforeItems = new ArrayList<>();
        for (int[] row : bf) {
            List<Integer> rowList = new ArrayList<>();
            for (int num : row) {
                rowList.add(num);
            }
            beforeItems.add(rowList);
        }

        System.out.println(Arrays.toString(sortItems(8,  2, groups, beforeItems)));
    }

    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] indeg = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                continue;
            }
            ArrayList<Integer> members = map.getOrDefault(group[i], new ArrayList<Integer>());
            members.add(i);
            map.put(group[i], members);
        }
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> prevs = beforeItems.get(i);
            for (int j = 0; j < prevs.size(); j++) {
                List<Integer> adjacent = adj.get(prevs.get(j));
                ArrayList<Integer> members = map.get(group[i]);
                if (members == null || group[i] == group[prevs.get(j)]) {
                    adjacent.add(i);
                } else {
                    for (int k = 0; k < members.size(); k++) {
                        adjacent.add(members.get(k));
                    }
                }
            }
        }
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indeg[adj.get(i).get(j)]++;
            }
        }
        System.out.println(Arrays.toString(indeg));
        System.out.println(adj);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int[] sol = new int[n];
        int solIndex = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.println(Arrays.toString(sol));
            System.out.println(solIndex);
            sol[solIndex++] = current;
            for (int i = 0; i < adj.get(current).size(); i++) {
                indeg[adj.get(current).get(i)]--;
            }
            ArrayList<Integer> members = map.getOrDefault(group[current], new ArrayList<Integer>());
            for (int i = 0; i < members.size(); i++) {
                if (indeg[members.get(i)] == 0) {
                    q.offer(members.get(i));
                }
            }
        }
        if (solIndex == sol.length) {
            return sol;
        } else {
            return new int[0];
        }
    }
}