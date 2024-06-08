from typing import *
from functools import *

# https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/description/

class Solution:
    def maxOperations(self, nums: List[int]) -> int:
        @cache
        def dfs(i: int, j: int, target: int) -> int:
            if i >= j:
                return 0
            ans = 0
            if nums[i] + nums[j] == target:
                ans = max(ans, dfs(i+1, j-1, target) + 1)
            if nums[j-1] + nums[j] == target:
                ans = max(ans, dfs(i, j-2, target) + 1)
            if nums[i] + nums[i+1] == target:
                ans = max(ans, dfs(i+2, j, target) + 1)
            return ans
        n = len(nums)
        res1 = dfs(2, n-1, nums[0] + nums[1])
        res2 = dfs(0, n-3, nums[-1] + nums[-2])
        res3 = dfs(1, n-2, nums[0] +nums[-1])
        return max(res1, res2, res3) + 1
