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


# https://leetcode.cn/problems/knight-dialer/description/

MOD = 10 ** 9 + 7
g = [[4, 6], [6, 8], [7, 9], [4, 8], [3, 9, 0], [], [1, 7, 0], [2, 6], [1, 3], [2, 4]]


@cache
def dfs(i: int, k: int) -> int:
    if k == 0: return 1
    ans = 0
    for j in g[i]:
        ans += dfs(j, k - 1)
        ans %= MOD
    return ans


class Solution:
    def knightDialer(self, n: int) -> int:
        res = 0
        for i in range(10):
            res += dfs(i, n - 1)
            res %= MOD
        return res
