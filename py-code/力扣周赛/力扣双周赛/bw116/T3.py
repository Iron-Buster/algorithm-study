from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from random import *
from typing import *
import random
import sys
import os
from io import BytesIO, IOBase
from copy import deepcopy
import threading

BUFSIZE = 4096
MOD = 10 ** 9 + 7
mod = 998244353
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))
def SUF(a):
    n = len(a)
    suf = [0] * (n + 1)
    for i in range(n - 1, -1, -1):
        suf[i] = suf[i + 1] + a[i]
    return suf
# 返回<=t的最后一个下标
def leftBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l
                                
# 返回>=t的第一个下标
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r) >> 1
        if a[mid] < t:
            l = mid + 1
        else:
            r = mid 
    return -1 if a[l] < t else l


# 100042. 和为目标值的最长子序列的长度
# 已解答
# 中等
# 相关企业
# 提示
# 给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。

# 返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。

# 子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。


class Solution:
    def lengthOfLongestSubsequence(self, nums: List[int], target: int) -> int:
        dp = [[-1 for _ in range(target)] for _ in range(len(nums))]
        
        def dfs(i: int, v: int) -> int:
            if v > target: return -inf
            if v == target: return 0
            if i >= len(nums): return -inf
            if dp[i][v] != -1: return dp[i][v]
            res = max(dfs(i + 1, v), dfs(i + 1, v + nums[i]) + 1)
            dp[i][v] = res
            return res
        ans = dfs(0, 0)
        return ans if ans > 0 else -1