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
def dfs(root: Optional[TreeNode]) -> int:
    if root:
        return max(dfs(root.left), dfs(root.right)) + 1
    return 0

# https://leetcode.cn/problems/balanced-binary-tree/
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        if abs(dfs(root.left) - dfs(root.right)) > 1:
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)