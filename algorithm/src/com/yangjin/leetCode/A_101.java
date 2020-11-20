package com.yangjin.leetCode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class A_101 {

    public static void main(String[] args) {
        A_101 a101 = new A_101();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(null);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(3);
        //[1,2,2,3,4,4,3]
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
//        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
//        treeNode2.right = treeNode6;

        System.out.println(a101.isSymmetric(treeNode));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return false;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
        }
        return false;
    }
}
