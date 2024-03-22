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

    # 2385. 感染二叉树需要的总时间
    #         已解答
    # 第 307 场周赛
    #         Q3
    # 1711
    # 相关标签
    #         相关企业
    # 提示
    # 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。

    # 每分钟，如果节点满足以下全部条件，就会被感染：

    # 节点此前还没有感染。
    # 节点与一个已感染节点相邻。
    # 返回感染整棵树需要的分钟数。


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        g = defaultdict(list)
        # 建图
        def buildGraph(root: Optional[TreeNode]) -> None:
            if not root: return
            x = root.val
            if root.left:
                y = root.left.val
                g[x].append(y)
                g[y].append(x)
                buildGraph(root.left)
            if root.right:
                y = root.right.val
                g[x].append(y)
                g[y].append(x)
                buildGraph(root.right)

        buildGraph(root)
        
        ans = 0
        def dfs(x: int, fa: int, depth: int) -> None:
            nonlocal ans
            for y in g[x]:
                if y == fa: continue
                dfs(y, x, depth + 1)
            ans = max(ans, depth)

        dfs(start, -1, 0)    
        return ans    
