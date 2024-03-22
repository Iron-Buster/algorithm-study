# 704. 二分查找
# 简单
# 1.4K
# 相关企业
# 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
# 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
#
from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + r >> 1
            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                return mid
        return -1


if __name__ == '__main__':
    print("ok")