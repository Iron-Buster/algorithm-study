# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head.next
        v = 0
        dummy = ListNode()
        curr = dummy

        while cur:
            if cur.val == 0:
                curr.next = ListNode(v)
                curr = curr.next
                v = 0
            else:
                v += cur.val
            cur = cur.next
        return dummy.next
