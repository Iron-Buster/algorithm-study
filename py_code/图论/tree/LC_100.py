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


# 100. 相同的树
# 已解答
# 简单
# 相关标签
# 相关企业
# 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

# 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        
        def dfs(o1: Optional[TreeNode], o2: Optional[TreeNode]) -> bool:
            if not o1 and not o2: return True
            if not o1 or not o2: return False
            if o1.val != o2.val: return False
            return dfs(o1.left, o2.left) and dfs(o1.right, o2.right)
        return dfs(p, q)