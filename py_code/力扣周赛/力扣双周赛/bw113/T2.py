

# 2856. 删除数对后的最小数组长度
# 已解答
# 中等
# 相关企业
# 提示
# 给你一个下标从 0 开始的 非递减 整数数组 nums 。

# 你可以执行以下操作任意次：

# 选择 两个 下标 i 和 j ，满足 i < j 且 nums[i] < nums[j] 。
# 将 nums 中下标在 i 和 j 处的元素删除。剩余元素按照原来的顺序组成新的数组，下标也重新从 0 开始编号。
# 请你返回一个整数，表示执行以上操作任意次后（可以执行 0 次），nums 数组的 最小 数组长度。


from collections import Counter
from typing import List
from sortedcontainers import SortedList

class Solution:
    def minLengthAfterRemovals(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        sl = SortedList(cnt.values())
        while len(sl) > 1:
            # SortedList的pop是弹出右边第一个元素
            a = sl.pop()
            b = sl.pop()
            a -= 1
            b -= 1
            if a: sl.add(a)
            if b: sl.add(b)
        return 0 if not sl else sl.pop()
