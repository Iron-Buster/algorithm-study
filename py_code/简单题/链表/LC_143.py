from typing import Optional


# 143. 重排链表


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head.next:
            return head
        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        head1 = self.reverseList(slow)
        while head1.next:
            nx = head.next
            nx1 = head1.next
            head.next = head1
            head1.next = nx
            head = nx
            head1 = nx1

    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        pre = None
        cur = head
        while cur:
            nxt = cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        return pre


if __name__ == '__main__':
    print("Ok")