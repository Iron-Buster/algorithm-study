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


'''
https://codeforces.com/problemset/problem/622/C

输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
然后输入 m 个询问，每个询问输入三个数 L R x(1≤x≤1e6)。
下标从 1 开始。

对于每个询问，输出任意 i，满足 i 在闭区间 [L,R] 内且 a[i] ≠ x。
如果不存在这样的 i，输出 -1。

'''


def solve():
    n, m = MII()
    a = LII()
    left = [-1] * n     # left[i] 表示左边最近的不等于a[i]的下标
    for i in range(1, n):
        if a[i] != a[i - 1]:
            left[i] = i - 1
        else:
            left[i] = left[i - 1]
    # print(*left)
    outs = []
    for _ in range(m):
        L, R, x = MII()
        L -= 1
        R -= 1
        if a[R] != x:
            outs.append(str(R + 1))
        elif left[R] >= L:  # 有一个不等于x的数字 在[L,R]范围内
            outs.append(str(left[R] + 1))
        else:
            outs.append('-1')

    print('\n'.join(outs))

if __name__ == '__main__':
    t = 1
    for _ in range(t):
        solve()
