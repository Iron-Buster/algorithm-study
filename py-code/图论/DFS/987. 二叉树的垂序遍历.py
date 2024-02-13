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
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        g = defaultdict(list)

        def dfs(o: Optional[TreeNode], row: int, col: int):
            if not o: return
            g[col].append([row, o.val])  # 将col相同的分组
            dfs(o.left, row + 1, col - 1)
            dfs(o.right, row + 1, col + 1)

        dfs(root, 0, 0)
        ans = []
        for _, gg in sorted(g.items()):
            gg.sort()  # 按照 row 排序，row 相同按照 val 排序
            ans.append([v for _, v in gg])
        return ans


