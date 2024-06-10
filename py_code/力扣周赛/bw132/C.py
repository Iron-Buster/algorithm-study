from functools import cache
from typing import *


# https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/description/

class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        @cache
        def dfs(i: int, k: int) -> int:
            if i >= n: return 0
            res = 0
            for j in range(i + 1, n):
                if nums[i] == nums[j]:
                    res = max(res, 1 + dfs(j, k))
                else:
                    if k > 0:
                        res = max(res, 1 + dfs(j, k - 1))
            return res
        
        return max(dfs(i, k) for i in range(n)) + 1