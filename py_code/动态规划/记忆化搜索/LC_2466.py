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

# https://leetcode.cn/problems/count-ways-to-build-good-strings/
class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:

        @cache
        def dfs(n: int) -> int:
            if n < 0: return 0
            if n == 0: return 1
            ans = 0
            ans = (ans + dfs(n - zero))
            ans = (ans + dfs(n - one))
            return ans

        res = 0
        for i in range(low, high + 1):
            res = (res + dfs(i))
        dfs.cache_clear()
        return res % MOD
