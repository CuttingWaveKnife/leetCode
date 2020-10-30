package com.yangjin.leetCode;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class A_69 {
    public static void main(String[] args) {
        A_69 a69 = new A_69();
        int x = 9;
        System.out.println(a69.mySqrt(x));
    }

    public int mySqrt(int x) {
        if (x==0) {
            return 0;
        }
        if (x==1) {
            return 1;
        }
        if (x==2) {
            return 1;
        }
        int num = (x - 1) / 2;
        if (num*num>x) {
            return mySqrt(num);
        }
        return num;
    }
}
