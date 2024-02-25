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

'''
https://leetcode.cn/problems/regular-expression-matching/
'''

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m = len(s) + 1
        n = len(p) + 1
        f = [[False] * n for _ in range(m)]
        f[0][0] = True
        for j in range(2, n, 2):
            f[0][j] = f[0][j-2] and p[j-1] == '*'
        for i in range(1, m):
            for j in range(1, n):
                if p[j-1] == '*':
                    if f[i][j-2]: f[i][j] = True
                    elif f[i-1][j] and (s[i-1] == p[j-2]): f[i][j] = True
                    elif f[i-1][j] and p[j-2] == '.': f[i][j] = True
                else:
                    if f[i-1][j-1] and (s[i-1] == p[j-1] or p[j-1] == '.'):
                        f[i][j] = True
        return f[-1][-1]