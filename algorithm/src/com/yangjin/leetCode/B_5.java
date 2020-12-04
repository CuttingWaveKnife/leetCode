package com.yangjin.leetCode;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class B_5 {

    public static void main(String[] args) {
        B_5 b5 = new B_5();
        String str = "babad";
        System.out.println(b5.longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        return null;
    }
}
