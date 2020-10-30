package com.yangjin.leetCode;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class A_67 {
    public static void main(String[] args) {
        A_67 a67 = new A_67();
        String a = "0";
        String b = "0";
        System.out.println(a67.addBinary(a, b));
//        System.out.println('1' + '0');
//        System.out.println('1');
//        System.out.println('0');
//        char add = 0;
//        char aaa = 33;
//        System.out.println(add + aaa);
    }

    public String addBinary(String a, String b) {
        int diff = a.length() - b.length();
        if (diff > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < diff; i++) {
                sb.append("0");
            }
            sb.append(b);
            b = sb.toString();
        } else if (diff < 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < -diff; i++) {
                sb.append("0");
            }
            sb.append(a);
            a = sb.toString();
        }
//        System.out.println(a+":"+b);
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int len = charsA.length;
        char[] charsC = new char[len];
        int add = 0;
        for (int i = len - 1; i >= 0; i--) {
            int aa = charsA[i] - 48;
            int bb = charsB[i] - 48;
            int num = aa + bb + add;
//            System.out.print(i+":"+num+"->");
            if (num > 1) {
                add = 1;
                num = num - 2;
            } else {
                add = 0;
            }
            char c = (char) (num + 48);
//            System.out.println(c);
            charsC[i] = c;
        }
        if (add>0) {
            return "1"+new String(charsC);
        }
        return new String(charsC);
    }
}
