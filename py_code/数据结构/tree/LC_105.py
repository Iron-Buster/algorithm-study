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


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        n = len(preorder)
        mp = defaultdict(int)
        for i, x in enumerate(inorder):
            mp[x] = i
        i = 0
        def dfs(left: int, right: int) -> Optional[TreeNode]:
            if left > right: return None
            nonlocal i
            if i >= n: return None
            # preorder 的第一个元素是root
            root_val = preorder[i]
            pos = mp[root_val]
            root = TreeNode(root_val)
            i += 1
            root.left = dfs(left, pos - 1)
            root.right = dfs(pos + 1, right)
            return root
        return dfs(0, n - 1)
