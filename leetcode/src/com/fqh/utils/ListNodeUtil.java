package com.fqh.utils;

import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 17:51
 **/
public class ListNodeUtil {

    public static ListNode constructListNode(List<Integer> list) {
        var dummy = new ListNode(-1);
        var cur = dummy;
        for (int x : list) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void printListNode(ListNode head) {
        var cur = head;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.val).append("->");
            cur = cur.next;
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        System.out.println(builder);
    }
}
