package com.fqh.链表题;

import com.fqh.utils.ListNode;
import com.fqh.utils.ListNodeUtil;

import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/28 17:45
 **/
public class LC_19 {

//    19. 删除链表的倒数第 N 个结点
//            尝试过
//    中等
//            相关标签
//    相关企业
//            提示
//    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

//    输入：head = [1,2,3,4,5], n = 2
//    输出：[1,2,3,5]
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        var dummy = new ListNode(0, head);
        var fast = dummy;
        var slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = ListNodeUtil.constructListNode(List.of(1, 2));
        ListNodeUtil.printListNode(new LC_19().removeNthFromEnd(head, 2));
    }
}
