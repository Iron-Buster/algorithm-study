from typing import Optional

# 24. 两两交换链表中的节点
# 中等
# 1.9K
# company
# 亚马逊
# company
# 彭博 Bloomberg
# company
# 字节跳动
# 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        dummy = ListNode(0, head)
        pre, cur = dummy, head
        while cur and cur.next:
            nx = cur.next
            nx2 = cur.next.next

            pre.next = nx  # 0 -> 2
            cur.next = nx2  # 2 -> 1
            nx.next = cur  # 1 -> 3

            pre = cur
            cur = nx2
        return dummy.next


if __name__ == '__main__':
    node1 = ListNode()
    print("Ok")
