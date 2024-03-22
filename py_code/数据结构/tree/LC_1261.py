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


# class FindElements:
#     def __init__(self, root: Optional[TreeNode]):
#         root.val = 0
#         self.mask = 0
#         self.dfs(root)
#
#     def find(self, target: int) -> bool:
#         return (self.mask >> target & 1) == 1
#
#     def dfs(self, root: Optional[TreeNode]) -> None:
#         if root:
#             if root.left:
#                 root.left.val = root.val * 2 + 1
#                 self.mask |= (1 << root.left.val)
#                 self.dfs(root.left)
#             if root.right:
#                 root.right.val = root.val * 2 + 2
#                 self.mask |= (1 << root.right.val)
#                 self.dfs(root.right)

class FindElements:

    def __init__(self, root: Optional[TreeNode]):
        self.root = root

    def find(self, target: int) -> bool:
        cur = self.root
        target += 1
        for i in range(target.bit_length() - 2, -1, -1):
            bit = (target >> i) & 1
            cur = cur.right if bit else cur.left
            if cur is None:
                return False
        return True
