package com.yangjin.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class A_118 {

    public static void main(String[] args) {
        A_118 a118 = new A_118();
        List<List<Integer>> all = a118.generate(10);
        int i = 0;
        int num = all.size();
        for (List<Integer> list : all) {
            for (int j = i; j < num; j++) {
                System.out.print(" ");
            }
            i++;
            System.out.print("[");
            for (int n = 0; n < list.size(); n++) {
                System.out.print(list.get(n));
                if (n != list.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> all = new ArrayList<>(numRows);
        List<Integer> prev=null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i + 1);
            if (i == 0) {
                list.add(1);
            } else {
                for (int j = 0; j <i; j++) {
                    if (j == 0) {
                        list.add(1);
                    } else {
                        list.add(prev.get(j)+prev.get(j - 1));
                    }
                }
                list.add(1);
            }
            all.add(list);
            prev = list;
        }
        return all;
    }
}
