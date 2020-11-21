package com.yangjin.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class A_107 {
    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        //[1,2,3,4,5]
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;

        A_107 a107 = new A_107();
        System.out.println(a107.levelOrderBottom(node0));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root != null) {
            bottom(root, lists, 0);
        }
        return lists;
    }

    private void bottom(TreeNode root, List<List<Integer>> lists, int depth) {
        int size = lists.size();
        if (size ==depth) {
            LinkedList<List<Integer>> linked = (LinkedList<List<Integer>>) lists;
            linked.addFirst(new ArrayList<>());
        }
        List<Integer> depths = lists.get(lists.size()-1-depth);
        depths.add(root.val);
        System.out.println(size+":"+depth);
        depth++;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) bottom(left, lists, depth);
        if (right !=null) bottom(right, lists, depth);
    }
}
