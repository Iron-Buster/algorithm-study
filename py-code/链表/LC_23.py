import heapq
from typing import Optional, List


# 23. 合并 K 个升序链表
# 困难
# 2.5K
# 相关企业
# 给你一个链表数组，每个链表都已经按升序排列。
#
# 请你将所有链表合并到一个升序链表中，返回合并后的链表。

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    #     pq = []
    #     for v in lists:
    #         while v:
    #             heapq.heappush(pq, v.val)
    #             v = v.next
    #     dummy = ListNode(0)
    #     cur = dummy
    #     while pq:
    #         cur.next = ListNode(heapq.heappop(pq))
    #         cur = cur.next
    #     return dummy.next

    # +++++++++++++++++++++++++++++++ 分治 +++++++++++++++++++++++++++++++++++++++++++=
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        n = len(lists)
        if n == 0: return None
        if n == 1: return lists[0]
        left = self.mergeKLists(lists[:n // 2])
        right = self.mergeKLists(lists[n // 2:])
        return self.mergeTwoLists(left, right)

    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None: return list2
        if list2 is None: return list1
        if list1.val < list2.val:
            list1.next = self.mergeTwoLists(list1.next, list2)
            return list1
        else:
            list2.next = self.mergeTwoLists(list1, list2.next)
            return list2


if __name__ == '__main__':
    print("ok")
