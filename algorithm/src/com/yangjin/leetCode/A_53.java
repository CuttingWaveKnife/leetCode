package com.yangjin.leetCode;

import java.util.Arrays;

/**
 * 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A_53 {
    public static void main(String[] args) {
        A_53 a53 = new A_53();
        System.out.println(a53.maxSubArray(new int[]{-2,1}));
    }

    public int maxSubArray(int[] nums) {
        return get(nums, 0, nums.length);
    }

    private int get(int[] nums, int start, int end) {
        int len = end - start;
        if (len == 1) {
            return nums[start];
        }
        int center = (start + end-1) / 2;
        System.out.println(start+":"+end+"="+len+";   "+center);
        int left = get(nums, start, center+1);
        int right = get(nums, center+1, end);
        int max = Math.max(left, right);
        int mix = nums[center] + nums[center + 1];
        if (len>2) {
            int lmax = mix;
            int l = lmax;
            for (int i = center - 1; i >= start; i--) {
                l = l + nums[i];
                lmax = Math.max(l, lmax);
            }
            int rmax = mix;
            int r = rmax;
            for (int i = center + 2; i < end; i++) {
                r = r + nums[i];
                rmax = Math.max(r, rmax);
            }
            mix = lmax + rmax - mix;
        }
        System.out.println(max+":"+mix);
        max = Math.max(max, mix);
        return max;
    }
}
