package com.yangjin.leetCode;

public class DoubleListNode {
    public int key;
    public int val;
    public DoubleListNode pre;
    public DoubleListNode next;

    public DoubleListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public void next(DoubleListNode next) {
        this.next = next;
    }

    public void pre(DoubleListNode pre) {
        this.pre = pre;
    }
}
