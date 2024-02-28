package com.fqh.utils;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 17:46
 **/
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
