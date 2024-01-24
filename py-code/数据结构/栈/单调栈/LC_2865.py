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


# https://leetcode.cn/problems/beautiful-towers-i/description/
class Solution:
    def maximumSumOfHeights(self, h: List[int]) -> int:
        n = len(h)
        left = [0] * (n + 1)
        right = [0] * (n + 1)
        stk = [-1]
        for i in range(n):
            while len(stk) > 1 and h[stk[-1]] > h[i]:
                stk.pop()
            left[i] = stk[-1]
            stk.append(i)
        stk = [n]
        for i in range(n - 1, -1, -1):
            while len(stk) > 1 and h[stk[-1]] > h[i]:
                stk.pop()
            right[i] = stk[-1]
            stk.append(i)
        a = [0] * n
        b = [0] * n
        a[0] = h[0]
        for i in range(1, n):
            a[i] = (i - left[i]) * h[i]
            if left[i] != -1:
                a[i] += a[left[i]]
        b[n - 1] = h[n - 1]
        for i in range(n - 2, -1, -1):
            b[i] = (right[i] - i) * h[i]
            if right[i] != n:
                b[i] += b[right[i]]

        ans = 0
        for i, x in enumerate(h):
            ans = max(ans, a[i] + b[i] - x)
        return ans
