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

def minOps(a: List[int]) -> int:
    b = a.copy()
    b.sort()
    mp = {}
    n = len(a)
    for i, x in enumerate(b):
        mp[x] = i
    r = 0
    vis = set()
    for i in range(n):
        if i not in vis:
            j = i
            while j not in vis:
                vis.add(j)
                j = mp[a[j]]
            r += 1
    return n - r

class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        q = deque({root})
        ans = 0
        while q:
            n = len(q)
            a = []
            for i in range(n):
                p = q.popleft()
                a.append(p.val)
                if p.left:
                    q.append(p.left)
                if p.right:
                    q.append(p.right)
            ans += minOps(a)
        return ans
