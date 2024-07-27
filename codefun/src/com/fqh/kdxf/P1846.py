Pimport sys
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


# https://codefun2000.com/p/P1846

'''
考虑每一个字符x, 它的贡献值 = (2^(cnt[x]-1)) * (2^(n-cnt[x]))
'''

def solve():
    s = I()
    n = len(s)
    cnt = Counter(s)
    res = 0
    for c in cnt:
        r = cnt[c]
        res = (res + (pow(2, r, mod) - 1) * pow(2, n - r, mod)) % mod
    print(res)


    


if __name__ == '__main__':
    t = 1
    for _ in range(t):
        solve()
