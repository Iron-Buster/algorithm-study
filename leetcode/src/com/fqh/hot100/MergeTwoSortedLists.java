package com.fqh.hot100;

import com.fqh.utils.ListNode;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/5 15:14
 **/
public class MergeTwoSortedLists {

    // https://leetcode.cn/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-100-liked

    // 合并两个有序链表

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }


}
