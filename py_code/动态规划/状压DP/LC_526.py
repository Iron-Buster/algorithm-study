from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))



# https://leetcode.cn/problems/beautiful-arrangement/description/



class Solution:
    def countArrangement(self, n: int) -> int:
        u = (1 << n) - 1
        @cache
        def dfs(s: int) -> int:
            if u == s:
                return 1
            res = 0
            i = s.bit_count() + 1
            for j in range(1, n + 1):
                if s >> (j - 1) & 1 == 0 and (i % j == 0 or j % i == 0):
                    res += dfs(s | (1 << (j - 1)))
            return res
        return dfs(0)

