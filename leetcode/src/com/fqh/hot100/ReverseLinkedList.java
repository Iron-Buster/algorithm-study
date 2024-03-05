package com.fqh.hot100;

import com.fqh.utils.ListNode;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/5 15:06
 **/
public class ReverseLinkedList {

    // https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
    // 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next, pre = null;
        var cur = head;
        while (cur != null) {
           next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
        }
        return pre;
    }
}
