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
# 二分找右边界
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r) >> 1
        if a[mid] < t:
            l = mid + 1
        else:
            r = mid 
    return -1 if a[l] < t else l
    
# 二分找左边界
def leftBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l


# LCP 07. 传递信息
# 已解答
# 简单
# 相关标签
# 相关企业
# 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：

# 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
# 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
# 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
# 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0

class Solution:
    def numWays(self, n: int, relation: List[List[int]], k: int) -> int:
        g = defaultdict(list)
        for x, y in relation:
            g[x].append(y)
        ans = 0
        def dfs(x: int, k: int) -> None:
            nonlocal ans
            if k == 0: 
                ans += x == n - 1
                return
            for y in g[x]:
                dfs(y, k - 1)
        dfs(0, k)
        return ans