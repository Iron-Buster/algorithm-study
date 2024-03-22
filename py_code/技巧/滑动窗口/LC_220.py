# 220. 存在重复元素 III
# 已解答
# 困难
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。

# 找出满足下述条件的下标对 (i, j)：

# i != j,
# abs(i - j) <= indexDiff
# abs(nums[i] - nums[j]) <= valueDiff
# 如果存在，返回 true ；否则，返回 false
import bisect
from sortedcontainers import SortedList
from typing import List

class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        st = SortedList()
        for i, x in enumerate(nums):
            if i > k:
                st.remove(nums[i - 1 - k])
            st.add(x)
            idx = bisect.bisect_left(st, x)
            if idx > 0 and abs(st[idx] - st[idx - 1]) <= t: return True
            if idx < len(st) - 1 and abs(st[idx + 1] - st[idx]) <= t: return True
        return False