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
from functools import cmp_to_key, lru_cache, reduce
from heapq import heapify, heappop, heappush, heappushpop, nlargest, nsmallest
from itertools import accumulate, combinations, permutations
from operator import add, iand, ior, itemgetter, mul, xor
from string import ascii_lowercase, ascii_uppercase
from typing import *
 

# https://leetcode.cn/problems/decode-ways/description/
class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        @cache
        def dfs(i: int) -> int:
            if i >= n: return 1
            if int(s[i]) == 0: return 0
            ans = dfs(i + 1)
            if i + 1 < n and int(s[i:i+2]) <= 26:
                ans += dfs(i + 2)
            return ans
        return dfs(0)
