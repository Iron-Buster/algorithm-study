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

# 2787. 将一个数字表示成幂的和的方案数
# 已解答
# 第 109 场双周赛
# Q4
# 1818
# 相关标签
# 相关企业
# 提示
# 给你两个 正 整数 n 和 x 。

# 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1x + n2x + ... + nkx 。

# 由于答案可能非常大，请你将它对 109 + 7 取余后返回。

# 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 23 + 33 + 53 。


class Solution:
    def numberOfWays(self, n: int, x: int) -> int:
        @cache
        def dfs(i: int, n: int) -> int:
            val = pow(i, x)
            if n == 0: return 1
            if n < 0 or n < val: return 0
            ans = dfs(i + 1, n - val) + dfs(i + 1, n)
            ans %= 1000000007
            return ans
        return dfs(1, n)
    