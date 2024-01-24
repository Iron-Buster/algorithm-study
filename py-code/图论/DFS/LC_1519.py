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

# 1519. 子树中标签相同的节点数
# 已解答
# 第 198 场周赛
# Q2
# 1809
# 相关标签
# 相关企业
# 提示
# 给你一棵树（即，一个连通的无环无向图），这棵树由编号从 0  到 n - 1 的 n 个节点组成，且恰好有 n - 1 条 edges 。树的根节点为节点 0 ，树上的每一个节点都有一个标签，也就是字符串 labels 中的一个小写字符（编号为 i 的 节点的标签就是 labels[i] ）

# 边数组 edges 以 edges[i] = [ai, bi] 的形式给出，该格式表示节点 ai 和 bi 之间存在一条边。

# 返回一个大小为 n 的数组，其中 ans[i] 表示第 i 个节点的子树中与节点 i 标签相同的节点数。

# 树 T 中的子树是由 T 中的某个节点及其所有后代节点组成的树

class Solution:
    '''
        dfs返回一个int[26] 保存子节点的标签信息
        父节点需要累加子节点的标签信息并往上返回
    '''
    def countSubTrees(self, n: int, edges: List[List[int]], labels: str) -> List[int]:
        res = [0] * n
        g = defaultdict(list)
        for x, y in edges:
            g[x].append(y)
            g[y].append(x)
        def dfs(x: int, fa: int) -> List[int]:
            cur = [0] * 26
            pos = ord(labels[x]) - ord('a')
            cur[pos] += 1
            for y in g[x]:
                if y == fa: continue
                # 子树的标签信息
                child = dfs(y, x)
                for i in range(26):
                    cur[i] += child[i]
            res[x] = cur[pos]
            return cur
        dfs(0, -1)
        return res
