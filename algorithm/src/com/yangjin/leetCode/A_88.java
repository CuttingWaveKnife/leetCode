package com.yangjin.leetCode;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 提示：
 * <p>
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */
public class A_88 {

    public static void main(String[] args) {
        A_88 a88 = new A_88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        a88.merge(nums1, m, nums2, n);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] cp = new int[m+n];
        for (int i = 0, j = 0, k=0; i < m || j < n; k++) {
            if (i==m) {
                cp[k] = nums2[j++];
                continue;
            }
            if (j==n) {
                cp[k] = nums1[i++];
                continue;
            }
            if (nums1[i]<nums2[j]) {
                cp[k]=nums1[i++];
            } else {
                cp[k] = nums2[j++];
            }
        }
        for (int i = 0; i < cp.length; i++) {
            nums1[i] = cp[i];
        }
    }
}
