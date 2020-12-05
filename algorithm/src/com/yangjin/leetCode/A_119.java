package com.yangjin.leetCode;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * <p>
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A_119 {
    public static void main(String[] args) {
        A_119 a119 = new A_119();
        List<Integer> list = a119.getRow(6);
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

    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[++rowIndex];
        Integer last = null;
        int pre;
        arr[0] = 1;
        if (rowIndex>1) {
            arr[1]=1;
        }
        for (int i = 2; i < rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                pre = arr[j] + arr[j - 1];
                if (j > 1) {
                    arr[j - 1] = last;
                }
                last = pre;
            }
            arr[i] = 1;
            arr[i - 1] = last;
        }
        return Arrays.asList(arr);
    }
}
