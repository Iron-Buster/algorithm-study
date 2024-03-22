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


# 2602. 使数组元素全部相等的最少操作次数
# 已解答
# 第 338 场周赛
# Q3
# 1903
# 相关标签
# 相关企业
# 提示
# 给你一个正整数数组 nums 。

# 同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。你可以执行以下操作 任意 次：

# 将数组里一个元素 增大 或者 减小 1 。
# 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。

# 注意，每次查询后，数组变回最开始的值。

class Solution:
    def minOperations(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        pre_sum = PF(nums)
        n = len(nums)
        ans = []
        for x in queries:
            l, r = 0, n - 1
            while l < r:
                mid = l + r >> 1
                if nums[mid] > x:
                    r = mid
                else:
                    l = mid + 1
            if nums[l] > x:
                left = l * x - pre_sum[l]                      # 左边
                right = pre_sum[n] - pre_sum[l] - (n - l) * x  # 右边
                ans.append(left + right)
            else:
                ans.append(n * x - pre_sum[n])
        return ans