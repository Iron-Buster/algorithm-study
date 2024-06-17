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

# https://codeforces.com/problemset/problem/1077/C

# 输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。

# 对于数组 b，如果 b 中存在一个数 x，使得 x = b 中其余元素之和，则称 b 为「好数组」。

# 如果删除 a[i] 可以使剩余元素组成好数组，则称 i 为「好下标」。
# 输出 a 的好下标的个数，以及所有好下标（任意顺序）。注意下标从 1 开始。


# 输入
# 5
# 2 5 1 2 2
# 输出
# 3
# 4 1 5

def solve():
    n = II()
    a = LII()

    s = sum(a)  
    b = []  
    for i, x in enumerate(a):
        b.append([i, x])
    b.sort(key=lambda x:x[1])

    cnt = 0
    res = []
    for i, (j, x) in enumerate(b):
        tmp = s - x
        if i == n - 1:
            if tmp == 2 * b[-2][1]:
                cnt += 1
                res.append(j + 1)
            break
        if tmp == 2 * b[-1][1]:
            cnt += 1
            res.append(j + 1)

    print(cnt)
    if cnt:
        print(*res)



 
 
if __name__ == '__main__':
    t = 1
    for _ in range(t):
        solve()
