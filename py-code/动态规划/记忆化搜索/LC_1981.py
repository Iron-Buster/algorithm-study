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


'''
https://leetcode.cn/problems/minimize-the-difference-between-target-and-chosen-elements/description/
'''

class Solution:
    def minimizeTheDifference(self, mat: List[List[int]], target: int) -> int:
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            mat[i].sort()
        ans = inf
        @cache
        def dfs(i: int, v: int) -> None:
            nonlocal ans
            if i == m:
                ans = min(ans, abs(v - target))
                return
            for j in range(n):
                if v > target and abs(v - target) >= ans:
                    break
                dfs(i + 1, v + mat[i][j])
        dfs(0, 0)
        return ans