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


# 2558. 从数量最多的堆取走礼物
# 已解答
# 第 331 场周赛
# Q1
# 1277
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：

# 选择礼物数量最多的那一堆。
# 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
# 选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
# 返回在 k 秒后剩下的礼物数量。


class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        q = [-x for x in gifts]
        heapify(q)
        while k:
            p = heappop(q)
            heappush(q, -isqrt(-p))
            k -= 1
        return -sum(q)
