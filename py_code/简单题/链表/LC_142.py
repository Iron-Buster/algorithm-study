from typing import Optional


# 142. 环形链表 II
# 中等
# 2.2K
# 相关企业
# 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
#
# 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
# 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
# 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        fast = slow = head
        ok = False
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                ok = True
                break
        if not ok: return None      # 无环
        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next
        return slow

if __name__ == '__main__':
    print("ok")