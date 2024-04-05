
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



# https://leetcode.cn/problems/maximum-score-of-spliced-array/description/

class Solution:
    '''
        枚举a和b是答案
        将a[l:r]中交换成b[l:r]
        _sum = sum(a) - a[l:r] + b[l:r]
        _sum = sum(a)
                - (a[l] + a[l+1] + ... + a[r])
                + (b[l] + b[l+1] + ... + b[r])
        _sum = sum(a) + (b[l]-a[l]) + (b[l+1]-a[l+1]) + ... + (b[r]-a[r])
        设b[i]-a[i] = diff[i] 然后找到一个最优的diff[l:r] 这个区间和最大
    '''

    def maximumsSplicedArray(self, nums1: List[int], nums2: List[int]) -> int:

        def f(a: List[int], b: List[int]) -> int:
            n, s = len(a), 0
            diff = [0] * n
            dp = [0] * n
            for i in range(n):
                diff[i] = b[i] - a[i]
                s += a[i]
            dp[0] = diff[0]
            ans = dp[0]
            for i in range(1, n):
                dp[i] = max(dp[i - 1] + diff[i], diff[i])
                ans = max(ans, dp[i])
            return ans + s

        res1 = f(nums1, nums2)
        res2 = f(nums2, nums1)
        return max(res1, res2)


