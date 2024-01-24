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

# 1123. 最深叶节点的最近公共祖先
# 第 145 场周赛
# Q2
# 1607
# 相关标签
# 相关企业
# 提示
# 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。

# 回想一下：

# 叶节点 是二叉树中没有子节点的节点
# 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
# 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    '''
        1.dfs计算出最大深度
        2.bfs找出该深度的节点
        3.LCA求出该深度从左到右的 第一个节点 和最后一个节点的最近公共祖先
    '''
    # 树LCA算法
    def LCA(self, root: Optional[TreeNode], p: Optional[TreeNode], q: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: return None
        if root == p or root == q: return root
        l = self.LCA(root.left, p, q)
        r = self.LCA(root.right, p, q)
        if l and r: return root
        return l if l else r

    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        nodes = []
        # DFS
        def dfs(o: Optional[TreeNode]) -> int:
            if not o: return 0
            return 1 + max(dfs(o.left), dfs(o.right))
        maxDepth = dfs(root)
        q = deque(root)
        level = 1
        # BFS
        while q:
            n = len(q)
            for i in range(n):
                p = q.popleft()
                if level == maxDepth: nodes.append(p)
                if p.left: q.append(p.left)
                if p.right: q.append(p.right)
            level += 1
        return self.LCA(root, nodes[0], nodes[-1])