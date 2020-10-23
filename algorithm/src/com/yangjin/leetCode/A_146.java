package com.yangjin.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2  缓存容量  )
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class A_146 {
    public static void main(String[] args) {
        int capacity = 2;
        A_146 obj = new A_146(capacity);

        obj.put(2,1);
        obj.put(2,2);
        System.out.println(obj.get(2));
//        obj.put(3,3);
//        System.out.println(obj.get(2));
    }

    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;
    private int capacity;

    public A_146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity+1);
    }

    public int get(int key) {
        ListNode listNode = map.get(key);
//        System.out.println(listNode);
        if (listNode != null) {
            if (this.head != listNode) up(listNode);
            return listNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node==null) {
            ListNode listNode = new ListNode(key, value);
            if (this.head != null) {
                listNode.next = this.head;
                this.head.pre = listNode;
            }
            map.put(key, listNode);
            this.head = listNode;
            if (this.tail==null) {
                this.tail = listNode;
            } else if (map.size()>capacity){
                map.remove(this.tail.key);
                ListNode pre = this.tail.pre;
                pre.next = null;
                this.tail = pre;
            }
        } else {
            node.val = value;
            if(this.head != node) {
                up(node);
            }
        }
    }

    private void up(ListNode node) {
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.next = next;
        if (next!=null) {
            next.pre = pre;
        } else {
            this.tail = pre;
        }
        node.pre = null;
        node.next = this.head;
        this.head.pre = node;
        this.head = node;
    }
}

class ListNode {
    int key;
    int val;
    ListNode pre;
    ListNode next;
    ListNode(int key,int val) { this.key = key; this.val = val; }

    void next(ListNode next) {
        this.next = next;
    }

    void pre(ListNode pre) {
        this.pre = pre;
    }
}