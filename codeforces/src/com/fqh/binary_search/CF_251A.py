import math
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

input = lambda: sys.stdin.readline().rstrip("\r\n")

# --------------------
def I():
    return input()

def II():
    return int(input())


def MII():
    return map(int, input().split())


def LI():
    return list(input().split())


def LII():
    return list(map(int, input().split()))


def GMI():
    return map(lambda x: int(x) - 1, input().split())


def LGMI():
    return list(map(lambda x: int(x) - 1, input().split()))

# mod = 998244353

'''
https://codeforces.com/problemset/problem/251/A

输入 n(1≤n≤1e5) d(1≤d≤1e9) 和长为 n 的严格递增数组 a(-1e9≤a[i]≤1e9)。
输出有多少个三元组 (i,j,k) 满足 i<j<k 且 a[k]-a[i]<=d。

a[k] <= d + a[i]

i..k
0   3

C(k-i, 2)种选法
'''

def solve():
     n, d = MII()
     a = LII()
     ans = 0
     for i in range(n - 2):
         l = i + 2
         r = n - 1
         t = d + a[i]
         while l < r:
             mid = (l + r + 1) >> 1
             if a[mid] <= t:
                l = mid
             else:
                r = mid - 1
         if a[l] <= t:
            ans += math.comb(l - i, 2)
     print(ans)


if __name__ == '__main__':
    t = 1
    for _ in range(t):
        solve()
