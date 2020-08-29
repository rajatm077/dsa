package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Cousins {
    public static void main(String[] args) {


        System.out.println(Math.floor(Math.log10(1) / Math.log10(2)));
    }

    public static boolean isCousins() {
        // int[] nodes = levelOrderTraversal(root);
        int[] nodes = { 1, 2, -1, -1, 3, -1, 4, 5 };
        int x = 3;
        int y = 4;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] < 0)
                continue;
            hm.put(nodes[i], i);
        }
        int idx = hm.get(x);
        int idy = hm.get(y);

        if (idx == 0 || idy == 0)
            return false;

        int dx = (int) Math.floor(Math.log10(idx + 1) / Math.log10(2));
        int dy = (int) Math.floor(Math.log10(idy + 1) / Math.log10(2));

        if (dx != dy)
            return false;

        int pxi = -1;
        int pyi = -1;
        if (idx % 2 == 0) {
            idx--;
        }
        pxi = idx / 2;
        if (idy % 2 == 0)
            idy--;
        pyi = idy / 2;

        return pxi != pyi;

    }

    public static int[] levelOrderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null)
                al.add(-1);
            else {
                al.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }
        return al.stream().mapToInt(i -> i).toArray();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}