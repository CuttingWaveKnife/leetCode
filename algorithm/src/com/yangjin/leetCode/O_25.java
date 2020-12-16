package com.yangjin.leetCode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 */
public class O_25 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        O_25 o25 = new O_25();
        ListNode listNode = o25.mergeTwoLists(node1, node4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode;
        if (l1.val > l2.val) {
            listNode = l2;
            l2 = l2.next;
        } else {
            listNode = l1;
            l1 = l1.next;
        }
        ListNode head = listNode;
        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            if (v1 > v2) {
                v1 = v2;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            ListNode node = new ListNode(v1);
            listNode.next = node;
            listNode = node;
        }
        if (l1 != null) {
            listNode.next = l1;
        }
        if (l2 != null) {
            listNode.next = l2;
        }
        return head;
    }
}
