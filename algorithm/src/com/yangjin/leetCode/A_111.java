package com.yangjin.leetCode;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 */
public class A_111 {
    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        A_111 a111 = new A_111();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        System.out.println(a111.minDepth(node1));
    }

    public int minDepth(TreeNode root) {
        if (root ==null) {
            return 0;
        }
        doit(root, 0);
        return min;
    }

    public void doit(TreeNode root, int depth) {
        if (root==null) {
            return;
        }
        depth++;
        if (depth>min && root.left!=null && root.right!=null) {
            return;
        }
        if (root.left==null && root.right==null) {
            min = Math.min(min, depth);
            return;
        }
        doit(root.left, depth);
        doit(root.right, depth);
    }
}
