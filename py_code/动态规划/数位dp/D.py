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


class Solution:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, suffix: str) -> int:

        def calc(s: str) -> int:

            @cache
            def dfs(i: int, v: int, isLmit: bool, isNum: bool) -> int:
                if i == len(s):
                    k = len(suffix)
                    x = str(v)
                    if x[-k:] != suffix:
                        return 0
                    return 1 if isNum else 0
                ans = 0
                if not isNum:
                    ans += dfs(i + 1, v, False, False)

                up = int(s[i]) if isLmit else 9
                up = max(up, limit)
                down = 0 if isNum else 1
                for d in range(down, up + 1):
                    v = v * 10 + d
                    ans += dfs(i + 1, v, isLmit and d == up, True)
                return ans

            return dfs(0, 0, True, False)
        return calc(str(finish)) - calc(str(start-1)) 
    


if __name__ == '__main__':
    ans = Solution().numberOfPowerfulInt(1, 6000, 4, "124")
    print(ans)

