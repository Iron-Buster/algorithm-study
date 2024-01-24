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
# 二分找右边界
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r) >> 1
        if a[mid] < t:
            l = mid + 1
        else:
            r = mid 
    return -1 if a[l] < t else l
    
# 二分找左边界
def leftBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l

# 2476. 二叉搜索树最近节点查询
# 第 320 场周赛
# Q2
# 1597
# 相关标签
# 相关企业
# 提示
# 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。

# 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：

# mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
# maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
# 返回数组 answer 。
# Definition for a binary tree node.



class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def closestNodes(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        a = []
        def dfs(o: Optional[TreeNode]) -> None:
            if o is None: return
            dfs(o.left)
            a.append(o.val)
            dfs(o.right)
        dfs(root)
        ans = []
        for q in queries:
            idx1 = leftBound(a, q)
            minv = -1 if idx1 == -1 else a[idx1]            
            idx2 = rightBound(a, q)
            maxv = -1 if idx2 == -1 else a[idx2]        
            ans.append([minv, maxv])
        return ans