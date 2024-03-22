from functools import cache
from typing import List


# 1035. 不相交的线
# 提示
# 1806
# 475
# 第 134 场周赛
# Q3
# 相关企业
# 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
#
# 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
#
#  nums1[i] == nums2[j]
# 且绘制的直线不与任何其他连线（非水平线）相交。
# 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
#
# 以这种方法绘制线条，并返回可以绘制的最大连线数。



class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        m, n = len(nums1), len(nums2)
        @cache
        def dfs(i: int, j: int) -> int:
            if i < 0 or j < 0: return 0
            return dfs(i - 1, j - 1) + 1 if nums1[i] == nums2[j] else max(dfs(i - 1, j), dfs(i, j - 1))
        return dfs(m - 1, n - 1)


if __name__ == '__main__':

    print("ok")
