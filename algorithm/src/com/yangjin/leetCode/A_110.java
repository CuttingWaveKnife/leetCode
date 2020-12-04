package com.yangjin.leetCode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * 输入：root = []
 * 输出：true
 * 提示：
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 */
public class A_110 {

    public static void main(String[] args) {
        //[1,2,2,3,3,null,null,4,4]
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
//        TreeNode treeNode6 = new TreeNode(3);
//        TreeNode treeNode7 = new TreeNode(3);
        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        System.out.println(new A_110().isBalanced(treeNode1));
    }

    public boolean isBalanced(TreeNode root) {
      return done(root).isBLT;
    }

    private Info done(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info info = new Info();

        Info leftInfo = done(root.left);
        Info rightInfo = done(root.right);
        if (leftInfo.isBLT && rightInfo.isBLT && Math.abs(leftInfo.high- rightInfo.high)<=1) {
            info.isBLT = true;
            info.high = Math.max(leftInfo.high, rightInfo.high) +1;
        } else {
            info.isBLT = false;
            info.high = Math.max(leftInfo.high, rightInfo.high) +1;
        }
        return info;
    }

    public static class Info{
        private boolean isBLT;
        private int high;

        public Info() {
        }

        public Info(boolean isBLT, int high) {
            this.isBLT = isBLT;
            this.high = high;
        }
    }
}
