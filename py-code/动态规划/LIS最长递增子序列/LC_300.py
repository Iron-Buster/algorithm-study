# 300. 最长递增子序列
# 中等
# 3.3K
# 相关企业
# 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
#
# 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
from functools import cache
from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        @cache
        def dfs(i: int) -> int:
            if i == len(nums): return 0
            ans = 0
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j]:
                    ans = max(ans, dfs(j) + 1)
            return ans
        return max(dfs(i) + 1 for i in range(len(nums)))


if __name__ == '__main__':

    print("ok")