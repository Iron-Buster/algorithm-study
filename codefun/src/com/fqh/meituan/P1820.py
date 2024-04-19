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

# https://codefun2000.com/p/P1820
# P1820. 2024.4.13-MT-第二题-最多0的个数
def solve():
    n, k = MII()
    a = LII()
    a.sort(key=lambda x:abs(x))
    ans = 0
    for x in a:
        if abs(x) > k:
            break
        k -= abs(x)
        ans += 1
    print(ans)



if __name__ == '__main__':
    # 1多组数据，0单组数据
    t = 0
    if t:
        t = II()
        for _ in range(t):
            solve()
    else:
        solve()
