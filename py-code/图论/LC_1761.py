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


class Solution:
    def minTrioDegree(self, n: int, edges: List[List[int]]) -> int:
        d = [0] * (n + 1)
        g = [[0 for _ in range(n+1)] for _ in range(n+1)]
        for (x, y) in edges:
            g[x][y] = 1
            g[y][x] = 1
            d[x] += 1
            d[y] += 1
        ans = inf
        for i in range(1, n + 1):
            for j in range(i + 1, n + 1):
                if g[i][j] == 1:
                    for k in range(j + 1, n + 1):
                        if g[i][k] == 1 and g[j][k] == 1:
                            ans = min(ans, d[i] + d[j] + d[k] - 6) # 减去这个三元组相互的贡献
        return -1 if ans == inf else ans
