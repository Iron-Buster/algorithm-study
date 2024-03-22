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

# https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/

class Solution:
    def jewelleryValue(self, frame: List[List[int]]) -> int:
        m = len(frame)
        n = len(frame[0])
        @cache
        def dfs(i: int, j: int) -> int:
                if i == m - 1 and j == n - 1:
                    return frame[i][j]
                ans = frame[i][j]
                a, b = 0, 0
                if i + 1 < m:
                    a = dfs(i + 1, j)
                if j + 1 < n:
                    b = dfs(i, j + 1)
                return ans + max(a, b)
        return dfs(0, 0)