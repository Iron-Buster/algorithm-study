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

# 1080. 根到叶路径上的不足节点
# 已解答
# 第 140 场周赛
# Q3
# 1805
# 相关标签
# 相关企业
# 提示
# 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。

# 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。

# 叶子节点，就是没有子节点的节点。


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:
        def dfs(o: Optional[TreeNode], sum: int) -> Optional[TreeNode]:
            if not o: return None
            sum += o.val
            if not o.left and not o.right:
                return None if sum < limit else o
            o.left = dfs(o.left, sum)
            o.right = dfs(o.right, sum)
            if o.left or o.right:
                return o
            else:
                return None
        return dfs(root, 0)
