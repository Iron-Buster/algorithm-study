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

# 2096. 从二叉树一个节点到另一个节点每一步的方向
# 第 270 场周赛
# Q3
# 1805
# 相关标签
# 相关企业
# 提示
# 给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。

# 请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：

# 'L' 表示从一个节点前往它的 左孩子 节点。
# 'R' 表示从一个节点前往它的 右孩子 节点。
# 'U' 表示从一个节点前往它的 父 节点。
# 请你返回从 s 到 t 最短路径 每一步的方向。


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    '''
        找到两个点的LCA
        这两个节点之间的距离 = V(start->LCA) + V(LCA->dest)
        dfs1: 计算LCA需要经过几次到达start start到LCA一定是U -> U * step
        dfs2: 计算LCA到target具体方向L,R
    '''
    def LCA(self, root: Optional[TreeNode], p: int, q: int) -> Optional[TreeNode]:
        if not root: return None
        if root.val == p or root.val == q:
            return root
        l = self.LCA(root.left, p, q)
        r = self.LCA(root.right, p, q)
        if l and r: return root
        return l if l else r
    

    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        lca = self.LCA(root, startValue, destValue)
        v1 = v2 = ''
        def dfs1(o: Optional[TreeNode], target: int, step: int) -> None:
            if not o: return
            if o.val == target:
                nonlocal v1
                v1 = step * 'U'
                return
            if o.left: dfs1(o.left, target, step + 1)
            if o.right: dfs1(o.right, target, step + 1)
        def dfs2(o: Optional[TreeNode], target: int, path: List[str]) -> None:
            if not o: return
            if o.val == target:
                nonlocal v2
                v2 = ''.join(path)
                return
            if o.left: 
                path.append('L')
                dfs2(o.left, target, path)
                path.pop()
            if o.right: 
                path.append('R')
                dfs2(o.right, target, path)
                path.pop()
        dfs1(lca, startValue, 0)
        dfs2(lca, destValue, [])
        return v1 + v2


