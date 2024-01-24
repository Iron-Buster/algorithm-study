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

# 1971. 寻找图中是否存在路径
# 已解答
# 简单
# 相关标签
# 相关企业
# 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。

# 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。

# 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。


class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        if source == destination: return True
        g = defaultdict(list)
        vis = [False] * n
        for x, y in edges:
            g[x].append(y)
            g[y].append(x)
        ans = False
        def dfs(x: int) -> None:
            if x == destination: 
                nonlocal ans
                ans = True
                return
            if vis[x]: return
            vis[x] = True
            for y in g[x]:
                dfs(y)
        dfs(source)
        return ans

