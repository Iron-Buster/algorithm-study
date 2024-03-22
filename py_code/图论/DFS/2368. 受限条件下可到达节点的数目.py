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
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        g = defaultdict(list)
        st = set(restricted)
        for (x,y) in edges:
            g[x].append(y)
            g[y].append(x)
        size = [0] * n
        def dfs(x: int, fa: int) -> None:
            size[x] = 1
            for y in g[x]:
                if y == fa or y in st:
                    continue
                dfs(y, x)
                size[x] += size[y]
        dfs(0, -1)
        return size[0]