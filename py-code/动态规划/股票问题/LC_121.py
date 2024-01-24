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



# 121. 买卖股票的最佳时机
# 已解答
# 简单
# 相关标签
# 相关企业
# 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

# 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

# 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。



class Solution:
    '''
        至少k次交易
    '''
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        @cache
        def dfs(i: int, j: int, state: int) -> int:
            if j < 0: return -inf
            if i < 0: return -inf if state else 0
            if state:
                return max(dfs(i - 1, j, state), dfs(i - 1, j, 0) - prices[i])
            else:
                return max(dfs(i - 1, j, state), dfs(i - 1, j - 1, 1) + prices[i])
        ans = dfs(n - 1, 1, 0)
        return 0 if ans < 0 else ans