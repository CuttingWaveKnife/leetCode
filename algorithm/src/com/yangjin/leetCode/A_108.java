package com.yangjin.leetCode;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class A_108 {
    public static void main(String[] args) {
        A_108 a108 = new A_108();
        int[] nums = {-10, -3, 0, 5, 9};
        a108.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
       return sortedArrayToBST(nums,0,nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int len = end - start;
        switch (len) {
            case 0:
                return null;
            case 1:
                return new TreeNode(nums[start]);
            default:
                int size = len / 2;
                int num3 = nums[start+size];
                TreeNode node = new TreeNode(num3);
                node.left = sortedArrayToBST(Arrays.copyOfRange(nums, start, start+size));
                node.right = sortedArrayToBST(Arrays.copyOfRange(nums, start+size + 1, end));
                return node;
        }
    }
}
