package com.yangjin.leetCode;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 *
 * 最后转换成了阶乘：1+1+2+3+5+8+。。。。。
 */
public class A_70 {

    public static void main(String[] args) {
        A_70 a70 = new A_70();
        int n = 4;
        System.out.println(a70.climbStairs(n));
    }

    public int climbStairs(int n) {
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 2;
        }
        int b=2;
        for (int a=1,i=3; i<=n; i++) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            b = a + b;
        }
        return b;
    }
}
