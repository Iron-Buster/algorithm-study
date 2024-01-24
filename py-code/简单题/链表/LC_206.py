# 206. 反转链表
# 简单
# 3.2K
# 相关企业
# 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        nxt = pre = None
        cur = head
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre


if __name__ == '__main__':
    print("ok")