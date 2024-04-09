package com.fqh.链表题;

import com.fqh.utils.ListNode;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/9 21:19
 **/
public class LC_92 {


    //https://leetcode.cn/problems/reverse-linked-list-ii/description/
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null, next;
        ListNode cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;

    }
}
