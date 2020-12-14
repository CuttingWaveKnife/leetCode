package com.yangjin.leetCode.top100;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class A_3 {
    public static void main(String[] args) {
        A_3 a3 = new A_3();
        String str = "ggububgvfk";
        System.out.println(a3.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {        int max = 0;
        if (s != null && s.length() > 0) {
            Set<Character> set = new HashSet<>();
            char[] chars = s.toCharArray();
            int length = chars.length;
            for (int i = 0, j = 0; i < length && j < length;  ) {
                char val = chars[j];
                boolean add = set.add(val);
                if (add) {
                    j++;
                    continue;
                }
                max = Math.max(max, set.size());
                do {
                    char aChar = chars[i++];
                    set.remove(aChar);
                } while (set.contains(val));
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
