'''
https://leetcode.cn/problems/minimum-positive-sum-subarray/description/

'''
from typing import List


class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        n = len(nums)
        ans = 0x3f3f3f3f
        for i in range(n):
            s = 0
            for j in range(i, n):
                L = j - i + 1
                if L > r: break
                s += nums[j]
                if l <= L <= r and s > 0:
                    ans = min(ans, s)
        return -1 if ans == 0x3f3f3f3f else ans