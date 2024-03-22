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

# https://leetcode.cn/problems/path-sum-ii/

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        ans = []

        def dfs(o: Optional[TreeNode], s: int, path: List[int]) -> None:

            if s == targetSum:
                if o.left is None and o.right is None:
                    ans.append(list(path))
            if o.left:
                path.append(o.left.val)
                dfs(o.left, s + o.left.val, path)
                path.pop()
            if o.right:
                path.append(o.right.val)
                dfs(o.right, s + o.right.val, path)
                path.pop()

        dfs(root, root.val, [root.val])
        return ans