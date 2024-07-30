import sys
import os
 
# import time
from bisect import bisect_left, bisect_right
# import functools
from math import ceil, floor, gcd, factorial, isqrt, sqrt, log2, log
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
 
# sys.setrecursionlimit(int(1e5 + 10))根据需要调整递归深度
dx, dy = [0, 1, 0, -1, 1, -1, 1, -1], [1, 0, -1, 0, -1, -1, 1, 1]
inf = float('inf')
# RANDOM = random.randint(int(1e9 + 7), int(2e9 + 7)) # 防止卡哈希
mod = int(1e9 + 7)
# mod = 998244353


# https://codefun2000.com/p/P1853

'''
ai = ak = aj+1
5
2 2 1 1 2

4


2: [0,1,4]
1: [2,3]
'''


def solve():
    n = II()
    a = LII()
    pos = defaultdict(list)
    for i, x in enumerate(a):
        pos[x].append(i)
    ans = 0
    # 枚举j，根据乘法原理，组合方案=j左边的合法i * j右边的合法k
    for j, x in enumerate(a):
        if (x+1) not in pos:
            continue
        p = pos[x+1]
        idx = bisect_right(p, j)
        # print(idx)
        ans += idx * (len(p) - idx)
    print(ans)




if __name__ == '__main__':
    t = 1
    for _ in range(t):
        solve()
