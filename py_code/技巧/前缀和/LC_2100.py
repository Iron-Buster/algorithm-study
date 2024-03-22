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

# 2100. 适合野炊的日子
# 第 67 场双周赛
# Q2
# 1702
# 相关标签
# 相关企业
# 提示
# 你和朋友们准备去野炊。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天的建议出行指数。日子从 0 开始编号。同时给你一个整数 time 。

# 如果第 i 天满足以下所有条件，我们称它为一个适合野炊的日子：

# 第 i 天前和后都分别至少有 time 天。
# 第 i 天前连续 time 天建议出行指数都是非递增的。
# 第 i 天后连续 time 天建议出行指数都是非递减的。
# 更正式的，第 i 天是一个适合野炊的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].

# 请你返回一个数组，包含 所有 适合野炊的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列

class Solution:
    '''
        前缀后缀分解 
        对于 i , a[i] >= time b[i] >= time 满足条件则i是合法的
    '''
    def goodDaysToRobBank(self, security: List[int], time: int) -> List[int]:
        n = len(security)
        a = [0] * n
        b = [0] * n
        for i in range(1, n):
            if security[i] <= security[i - 1]:
                a[i] = a[i - 1] + 1
        for i in range(n - 2, -1, -1):
            if security[i + 1] >= security[i]:
                b[i] = b[i + 1] + 1
        ans = []
        for i in range(time, n - time):
            if a[i] >= time and b[i] >= time:
                ans.append(i)
        return ans