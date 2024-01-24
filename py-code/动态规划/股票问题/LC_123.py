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



# 123. 买卖股票的最佳时机 III
# 困难
# 相关标签
# 相关企业
# 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

# 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

# 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。


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
        return dfs(n - 1, 2, 0)