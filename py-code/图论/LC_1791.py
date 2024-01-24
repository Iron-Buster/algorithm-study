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


# 1791. 找出星型图的中心节点
# 已解答
# 第 232 场周赛
# Q2
# 1287
# 相关标签
# 相关企业
# 提示
# 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，
# 并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。

# 给你一个二维整数数组 edges ，
# 其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点

class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        rd = Counter()
        n = 0
        for x, y in edges:
            rd[x] += 1
            rd[y] += 1
            n = max(n, x, y)
        ans = -1
        for x in rd:
            if rd[x] == n - 1: 
                ans = x
        return ans