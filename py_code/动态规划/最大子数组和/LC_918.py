from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))


# https://leetcode.cn/problems/maximum-sum-circular-subarray/description/

class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        s = sum(nums)
        n = len(nums)
        # dp[i][0] 表示以i结尾的最大子数组和
        # dp[i][1] 表示以i结尾的最小子数组和
        dp = [[0 for _ in range(2)] for _ in range(n)]
        dp[0][0] = dp[0][1] = nums[0]
        mx = dp[0][0]
        mn = dp[0][1]
        for i in range(1, n):
            dp[i][0] = max(dp[i - 1][0] + nums[i], nums[i])
            dp[i][1] = min(dp[i - 1][1] + nums[i], nums[i])
            mx = max(mx, dp[i][0])
            mn = min(mn, dp[i][1])
        if s - mn == 0:
            return mx
        return max(mx, s - mn)
