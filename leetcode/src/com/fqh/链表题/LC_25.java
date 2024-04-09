package com.fqh.链表题;

import com.fqh.utils.ListNode;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/9 21:27
 **/
public class LC_25 {

    //https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-100-liked
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;

        ListNode pre = null, next;
        cur = p0.next;
        while (n >= k) {
            n -= k;
            for (int i = 0; i < k; i++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;

    }
}
