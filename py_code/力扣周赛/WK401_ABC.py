import sys
import os
 
# import time
from bisect import bisect_left, bisect_right
# import functools
from math import ceil, floor, gcd, factorial, sqrt, log2, log
import random
# import re
from collections import Counter, defaultdict, deque
# from copy import deepcopy
from functools import cache, cmp_to_key, lru_cache, reduce
from heapq import heapify, heappop, heappush, heappushpop, nlargest, nsmallest
from itertools import accumulate, combinations, permutations
from operator import add, iand, ior, itemgetter, mul, xor
from string import ascii_lowercase, ascii_uppercase
from typing import *
 
# https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/

class C:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        st = set(rewardValues)
        a = [x for x in st]
        a.sort()
        n = len(a)

        @cache
        def dfs(i: int, x: int) -> int:
            if i >= n: return 0
            # 不选
            res1 = res2 = 0
            res1 = dfs(i + 1, x)
            # 选
            if a[i] > x:
                res2 = dfs(i + 1, x + a[i]) + a[i]
            return max(res1, res2)
        return dfs(0, 0)


# https://leetcode.cn/problems/find-the-n-th-value-after-k-seconds/
class B:
    def valueAfterKSeconds(self, n: int, k: int) -> int:
        a = [1] * n
        MOD = 10 ** 9 + 7
        while k:
            for i in range(1, n):
                a[i] += a[i-1]
            k -= 1
        return a[-1] % MOD
    

# https://leetcode.cn/problems/find-the-child-who-has-the-ball-after-k-seconds/
class A:
    def numberOfChild(self, n: int, k: int) -> int:
        res = 0
        dir = True
        i = 0
        while k:
            if i == n - 1:
                dir = False
            elif i == 0:
                dir = True

            if dir:
                res += 1
                i += 1
            else:
                res -= 1
                i -= 1
            k -= 1
        return res
    
