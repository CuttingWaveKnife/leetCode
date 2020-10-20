package com.yangjin.leetCode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class A_28 {

    public static void main(String[] args) {
        A_28 a28 = new A_28();
        String haystack = "aaaaa", needle = "bba";
        System.out.println(a28.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        int count = 0;
        char[] chars = haystack.toCharArray();
        char[] charArray = needle.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            for (int i = 0; i < charArray.length; i++) {
                count++;
                int n = j + i;
                if (n==chars.length) {
                    System.out.println(count);
                    return -1;
                }
                char aChar = chars[n];
                if (charArray[i] != aChar) {
                    break;
                }
                if (i == charArray.length - 1) {
                    System.out.println(count);
                    return j;
                }
            }
        }
        System.out.println(count);
        return -1;
    }
}
