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

# 2171. 拿出最少数目的魔法豆
# 已解答
# 第 280 场周赛
# Q3
# 1748
# 相关标签
# 相关企业
# 提示
# 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。

# 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。

# 请返回你需要拿出魔法豆的 最少数目。


''''

    1 4 5 6
    前缀和  0 1 5 10 16
    如果beans[i]保留了 那么小于beans[i]的数字都需要变为0 大于beans[i]的数字都要变为beans[i]
    排序后 枚举beans[i]作为最后保留的数字，
        cost[i] = preSum[i] + (preSum[n] - preSum[i] - (n - i) * beans[i])
        取min(cost)
'''

class Solution:
    def minimumRemoval(self, beans: List[int]) -> int:
        beans.sort()
        pre_sum = PF(beans)
        ans = inf
        n = len(beans)
        for i, x in enumerate(beans):
            left = pre_sum[i]
            right = (pre_sum[n] - pre_sum[i]) - (n - i) * x
            ans = min(ans, left + right)
        return ans
