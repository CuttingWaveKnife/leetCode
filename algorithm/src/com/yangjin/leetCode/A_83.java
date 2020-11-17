package com.yangjin.leetCode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class A_83 {

    public static void main(String[] args) {
        A_83 a83 = new A_83();
        System.out.println(a83.deleteDuplicates(null));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return null;
        }
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            if (curr.val == next.val) {
                next = next.next;
                curr.next = next;
            } else {
                curr = next;
                next = next.next;
            }
        }
        return head;
    }
}
