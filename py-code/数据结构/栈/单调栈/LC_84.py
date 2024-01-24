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
# 二分找右边界
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r) >> 1
        if a[mid] < t:
            l = mid + 1
        else:
            r = mid 
    return -1 if a[l] < t else l
    
# 二分找左边界
def leftBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l


# 84. 柱状图中最大的矩形
# 已解答
# 困难
# 相关标签
# 相关企业
# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

# 求在该柱状图中，能够勾勒出来的矩形的最大面积。


class Solution:
    '''
        单调栈
    '''
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        h = [-1] + heights + [-1] # 哨兵节点
        left = [0] * (n + 2)
        right = [0] * (n + 2)
        stk = []
        stk.append(0)
        for i in range(1, n + 1):
            while h[stk[-1]] >= h[i]:
                stk.pop()
            left[i] = stk[-1] + 1
            stk.append(i)
        stk = []
        stk.append(n + 1)
        for i in range(n, 0, -1):
            while h[stk[-1]] >= h[i]:
                stk.pop()
            right[i] = stk[-1] - 1
            stk.append(i)
        ans = 0
        for i in range(1, n + 1):
            ans = max(ans, h[i] * (right[i] - left[i] + 1))
        return ans


