from functools import reduce
from math import gcd, lcm
from typing import List

'''
https://leetcode.cn/problems/find-the-maximum-factor-score-of-array/description/
'''

class Solution:
    def maxScore(self, nums: List[int]) -> int:
        n = len(nums)
        g0 = 0
        l0 = 1
        ans = 0
        for i in range(n):
            g = -1
            l = -1
            g0 = gcd(g0, nums[i])
            l0 = lcm(l0, nums[i])
            for j in range(n):
                if j == i: continue
                if g == -1:
                    g = nums[j]
                    l = nums[j]
                    continue
                g = gcd(g, nums[j])
                l = lcm(l, nums[j])
            ans = max(ans, g * l)
        return max(ans, g0 * l0)
