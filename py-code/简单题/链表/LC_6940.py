# 6940. 在链表中插入最大公约数
# 中等
# 1
# 给你一个链表的头 head ，每个结点包含一个整数值。
#
# 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
#
# 请你返回插入之后的链表。
#
# 两个数的 最大公约数 是可以被两个数字整除的最大正整数
from math import gcd
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur = head
        while cur.next:
            cur.next = ListNode(gcd(cur.val, cur.next.val), cur.next)
            cur = cur.next.next
        return head

if __name__ == '__main__':
    print("Ok")