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


# 2876. 有向图访问计数
# 困难
# 相关标签
# 相关企业
# 提示
# 现有一个有向图，其中包含 n 个节点，节点编号从 0 到 n - 1 。此外，该图还包含了 n 条有向边。

# 给你一个下标从 0 开始的数组 edges ，其中 edges[i] 表示存在一条从节点 i 到节点 edges[i] 的边。

# 想象在图上发生以下过程：

# 你从节点 x 开始，通过边访问其他节点，直到你在 此过程 中再次访问到之前已经访问过的节点。
# 返回数组 answer 作为答案，其中 answer[i] 表示如果从节点 i 开始执行该过程，你可以访问到的不同节点数。


class Solution:
    ''' 
        内向基环树
        1.拓扑排序将环分离出来
    '''
    def countVisitedNodes(self, edges: List[int]) -> List[int]:
        n = len(edges)
        rd = [0] * n            # 入度
        ans = [0] * n           
        g = defaultdict(list)   # 反图 针对内向基环树 g[i] 存储可以到达i的所有点 
        for x, y in enumerate(edges):
            rd[y] += 1
            g[y].append(x)
        q = [i for i in range(n) if rd[i] == 0] # 将叶结点初始化进q
        while q:
            p = q.pop()             # 用叶结点做拓扑排序，将挂在基树环上的点都标记入度为0
            w = edges[p]
            rd[w] -= 1
            if rd[w] == 0: q.append(w)
        # 反向dfs函数
        def rdfs(u: int, depth: int) -> None:
            ans[u] = depth
            for v in g[u]:
                if rd[v] == 0:      # 是一条反向边
                    rdfs(v, depth + 1)
        for i in range(n):
            if rd[i] <= 0: continue # 不是环上的点
            ring = [i]
            w = edges[i]
            while w != i and rd[w] != -1:   # 环上跑计算 ring
                rd[w] = -1
                ring.append(w)
                w = edges[w]
            # 反向dfs更新ans
            for u in ring:
                rdfs(u, len(ring))
        return ans
        