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


# 100094. 子数组不同元素数目的平方和 I
# 已解答
# 简单
# 相关企业
# 提示
# 给你一个下标从 0 开始的整数数组 nums 。

# 定义 nums 一个子数组的 不同计数 值如下：

# 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
# 请你返回 nums 中所有子数组的 不同计数 的 平方 和。

# 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。

# 子数组指的是一个数组里面一段连续 非空 的元素序列。


class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            for j in range(i+1, n+1):
                cnt = Counter(nums[i:j])
                ans += len(cnt) * len(cnt)
        ans %= 1000000007
        return ans