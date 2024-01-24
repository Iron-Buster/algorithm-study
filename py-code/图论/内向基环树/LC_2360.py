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

# 2360. 图中的最长环
# 已解答
# 第 304 场周赛
# Q4
# 1897
# 相关标签
# 相关企业
# 提示
# 给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，其中每个节点 至多 有一条出边。

# 图用一个大小为 n 下标从 0 开始的数组 edges 表示，节点 i 到节点 edges[i] 之间有一条有向边。如果节点 i 没有出边，那么 edges[i] == -1 。

# 请你返回图中的 最长 环，如果没有任何环，请返回 -1 。

# 一个环指的是起点和终点是 同一个 节点的路径。

class Solution:
    '''  
        内向基环树
        1.拓扑排序将环分离出来
        2.然后再枚举所有环维护最大值
    '''
    def longestCycle(self, edges: List[int]) -> int:
        n = len(edges)
        rd = [0] * n
        for v in edges:
            if v == -1: continue    # 入度 + 1
            rd[v] += 1
        q = [i for i in range(n) if rd[i] == 0] # 将叶结点初始化进q
        while q:
            p = q.pop()             # 用叶结点做拓扑排序，将挂在基树环上的点都标记入度为0
            w = edges[p]
            if w != -1: 
                rd[w] -= 1
                if rd[w] == 0: q.append(w)
        ans = -1
        for i in range(n):
            if rd[i] == 0: continue # 不是环上的点
            ring = 1
            w = edges[i]
            while w != i and rd[w] != -1:   # 环上跑计算 ring
                rd[w] = -1
                ring += 1
                w = edges[w]
            ans = max(ans, ring)
        return ans

        