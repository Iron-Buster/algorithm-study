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
    '''
        1.相同数字一定要在同一个子数组中
        2.推论: 对于一个数字a 找到a最左边的下标p 和最右边的下标q 
            那么 [p, q]是不能分割的
        3.区间合并

        算法
        1.遍历数组，维护每个元素最后一次出现的下标
        2.再次遍历数组，去合并区间
    '''
    def numberOfGoodPartitions(self, nums: List[int]) -> int:
        r = {}
        for i, x in enumerate(nums):
            r[x] = i
        m = max_r = 0
        for i, x in enumerate(nums):
            max_r = max(max_r, r[x])
            if max_r == i:
                # 当前区间合并完毕
                m += 1
        return pow(2, m - 1, MOD) 