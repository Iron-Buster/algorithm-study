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
def SUF(a):
    n = len(a)
    suf = [0] * (n + 1)
    for i in range(n - 1, -1, -1):
        suf[i] = suf[i + 1] + a[i]
    return suf
# 返回<=t的最后一个下标
def leftBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l
                                
# 返回>=t的第一个下标
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r) >> 1
        if a[mid] < t:
            l = mid + 1
        else:
            r = mid 
    return -1 if a[l] < t else l

DIRS = [[-1, 0], [0, -1], [-1, -1]]

class Solution:
    def pathsWithMaxScore(self, board: List[str]) -> List[int]:
        m = len(board)
        n = len(board[0])
        @cache
        def dfs(i: int, j: int) -> List[int]:
            if i == 0 and j == 0: return [0, 1]
            res = [0, 0]
            for d in DIRS:
                nx = i + d[0]
                ny = j + d[1]
                if nx >= 0 and ny >= 0 and board[nx][ny] != 'X':
                    sub = dfs(nx, ny)
                    if sub[0] > res[0]:
                        res[0] = sub[0]
                        res[1] = sub[1]
                    elif sub[0] == res[0]:
                        res[1] += sub[1]
                        res[1] %= 1000000007
            if res[1] != 0:
                if board[i][j] != 'S':
                    res[0] += int(board[i][j])
            return res
        return dfs(m - 1, n - 1)
