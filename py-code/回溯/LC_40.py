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

# https://leetcode.cn/problems/combination-sum-ii/

class Solution:
    def combinationSum2(self, c: List[int], target: int) -> List[List[int]]:
        n = len(c)
        c.sort()
        ans = []
        def dfs(i: int, t: int, path: List[int]) -> None:
            if t == 0:
                ans.append(list(path))
                return
            for j in range(i, n):
                if c[j] > t:
                    break
                if j > i and c[j] == c[j-1]: # 剪枝
                    continue
                path.append(c[j])
                dfs(j + 1, t - c[j], path)
                path.pop()
        dfs(0, target, [])
        return ans

