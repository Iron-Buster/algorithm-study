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


# https://codefun2000.com/p/P1851



def solve():
    q = II()
    outs = []
    for _ in range(q):
        a,b,c,d,e = MII()
        if a == c == e and b == d and a > b:
            outs.append('Yes')
        else:
            outs.append('No')
    for out in outs:
        print(out)


if __name__ == '__main__':
    t = 1
    for _ in range(t):
        solve()
