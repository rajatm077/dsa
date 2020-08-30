package leetcode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/
 */
public class MaxDepthBT {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

