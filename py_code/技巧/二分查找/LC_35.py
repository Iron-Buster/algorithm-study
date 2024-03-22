# 35. 搜索插入位置
# 已解答
# 简单
# 相关标签
# 相关企业
# 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

# 请必须使用时间复杂度为 O(log n) 的算法。


from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums)
        while l < r:
            mid = l + r >> 1
            if nums[mid] >= target: r = mid
            else: l = mid + 1
        return l
    