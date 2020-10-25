package com.yangjin.leetCode;

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class A_61 {

    public static void main(String[] args) {
        A_61 a61 = new A_61();
        int[] arrays = new int[]{1,2,3};
        int[] ints = a61.plusOne(arrays);
        for (int anInt : ints) {
            System.out.println(anInt+",");
        }
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1]<9) {
            digits[len-1] = digits[len-1] +1;
            return digits;
        }
        for (int i = len - 1; i >= 0; i--) {
            int digit = digits[i];
            if (++digit==10) {
                digits[i] = 0;
            } else {
                digits[i] = digit;
                return digits;
            }
        }
        int[] cps = new int[digits.length+1];
        cps[0] = 1;
        for (int i = 1; i < cps.length; i++) {
            cps[i] = digits[i-1];
        }
        return cps;
    }
}
