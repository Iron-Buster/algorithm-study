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

# https://leetcode.cn/problems/ones-and-zeroes/description/

class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        @cache
        def dfs(idx: int, i: int, j: int) -> int:
            if i < 0 or j < 0: return -inf
            if idx >= len(strs): return 0
            # 不选
            res1 = dfs(idx + 1, i, j)
            # 选
            cnt0 = cnt1 = 0
            for c in strs[idx]:
                if c == '1':
                    cnt1 += 1
                else:
                    cnt0 += 1
            res2 = dfs(idx + 1, i - cnt0, j - cnt1) + 1
            return max(res1, res2)

        return dfs(0, m, n)
