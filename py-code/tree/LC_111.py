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

# 111. 二叉树的最小深度
# 已解答
# 简单
# 相关标签
# 相关企业
# 给定一个二叉树，找出其最小深度。

# 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

# 说明：叶子节点是指没有子节点的节点。

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        depth = 1
        q = deque([root])
        while len(q):
            n = len(q)
            for _ in range(n):
                p = q.popleft()
                if not p.left and not p.right:
                    return depth
                if p.left: q.append(p.left)
                if p.right: q.append(p.right)
            depth += 1
        return 0