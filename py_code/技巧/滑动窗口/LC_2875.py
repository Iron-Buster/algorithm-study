from math import inf
from typing import List

'''
https://leetcode.cn/problems/minimum-size-subarray-in-infinite-array/description/?envType=problem-list-v2&envId=sliding-window
'''

class Solution:
    def minSizeSubarray(self, nums: List[int], target: int) -> int:
        n = len(nums)
        total = sum(nums)
        s = 0
        j = 0
        ans = inf
        for i in range(n * 2):
            s += nums[i % n]
            while s > target % total:
                s -= nums[j % n]
                j += 1
            if s == target % total:
                ans = min(ans, i - j + 1)
        return ans + target // total * n if ans < inf else -1


