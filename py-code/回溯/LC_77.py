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

# 77. 组合
# 已解答
# 中等
# 相关标签
# 相关企业
# 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

# 你可以按 任何顺序 返回答案。

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        path = []
        def dfs(cur: int) -> None:
            if k - len(path) == 0:
                ans.append(path.copy())
                return
            for i in range(cur + 1, n + 1):
                path.append(i)
                dfs(i)
                path.pop()
        dfs(0)
        return ans