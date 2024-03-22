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

# 1774. 最接近目标价格的甜点成本
# 已解答
# 第 230 场周赛
# Q2
# 1702
# 相关标签
# 相关企业
# 提示
# 你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：

# 必须选择 一种 冰激凌基料。
# 可以添加 一种或多种 配料，也可以不添加任何配料。
# 每种类型的配料 最多两份 。
# 给你以下三个输入：

# baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
# toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
# target ，一个整数，表示你制作甜点的目标价格。
# 你希望自己做的甜点总成本尽可能接近目标价格 target 。

# 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。




class Solution:
    '''
        对于每一种配料，只有三种搜索情况
        1.不选
        2.选1次
        3.选2次
    '''
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        ans = inf
        smaller = inf
        def dfs(i: int, v: int):
            nonlocal ans, smaller
            if v - target > abs(ans - target): # 剪枝，当前已经大于最小的与target的差值，后面的v只会越来越大
                return
            if i >= len(toppingCosts):
                diff = abs(v - target)
                if diff < smaller:
                    ans = v
                    smaller = diff
                elif diff == smaller:
                    ans = min(ans, v)
                return
            dfs(i + 1, v)
            dfs(i + 1, v + toppingCosts[i])
            dfs(i + 1, v + 2 * toppingCosts[i])
        for b in baseCosts:
            dfs(0, b)
        return ans



