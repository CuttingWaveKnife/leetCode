package com.yangjin.leetCode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class A_104 {
    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node2.left = node5;
        node2.right = node6;

        A_104 a104 = new A_104();
        System.out.println(a104.maxDepth(node0));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depth(root, 0);
    }

    private int depth(TreeNode root, int depth) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        depth++;
        if (left == null && right == null) {
            return depth;
        }
        if (left != null && right == null) {
            return depth(left, depth);
        }
        if (left == null && right != null) {
            return depth(right, depth);
        }
        return Math.max(depth(left, depth), depth(right, depth));
    }
}
