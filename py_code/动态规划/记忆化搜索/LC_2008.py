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


# 2008. 出租车的最大盈利
# 已解答
# 第 61 场双周赛
# Q3
# 1872
# 相关标签
# 相关企业
# 提示
# 你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。

# 乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。

# 每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。

# 给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。

# 注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。

class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        g = defaultdict(list)
        for r in rides:
            g[r[0]].append(r)

        @cache
        def dfs(i: int) -> int:
            if i >= n: return 0
            ans = dfs(i + 1)
            if len(g[i]) > 0:
                for r in g[i]:
                    v = r[1] - r[0] + r[2]
                    ans = max(ans, dfs(r[1]) + v)
            return ans
        
        return dfs(0)