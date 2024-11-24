'''

https://leetcode.cn/problems/minimum-array-sum/description/
'''
from functools import cache
from typing import List


class Solution:
    def minArraySum(self, nums: List[int], k: int, op1: int, op2: int) -> int:
        n = len(nums)

        @cache
        def dfs(i: int, op1: int, op2: int) -> int:
            if i >= n: return 0
            ans = dfs(i + 1, op1, op2) + nums[i]
            if op1:
                ans = min(ans, dfs(i + 1, op1 - 1, op2) + (nums[i] + 1) // 2)
            if op2 and nums[i] >= k:
                ans = min(ans, dfs(i + 1, op1, op2 - 1) + (nums[i] - k))
            if op1 and op2 and nums[i] >= k:
                v = (nums[i] - k + 1) // 2
                if ((nums[i] + 1) // 2) >= k:
                    v = min(v, (nums[i] + 1) // 2 - k)
                ans = min(ans, dfs(i + 1, op1 - 1, op2 - 1) + v)
            return ans

        return dfs(0, op1, op2)
