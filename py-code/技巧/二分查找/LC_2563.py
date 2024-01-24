
# 2563. 统计公平数对的数目
# 第 332 场周赛
# Q2
# 1721
# 相关标签
# 相关企业
# 提示
# 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，和两个整数 lower 和 upper ，返回 公平数对的数目 。

# 如果 (i, j) 数对满足以下情况，则认为它是一个 公平数对 ：

# 0 <= i < j < n，且
# lower <= nums[i] + nums[j] <= upper


from bisect import *
from typing import List


class Solution:
    def countFairPairs(self, nums: List[int], lower: int, upper: int) -> int:
        ans = 0
        nums.sort()
        for j, x in enumerate(nums):
            l = bisect_left(nums, lower - x, 0, j)
            r = bisect_right(nums, upper - x, 0, j)
            ans += r - l
        return ans
