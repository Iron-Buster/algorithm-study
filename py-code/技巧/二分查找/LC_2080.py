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
    


# 2080. 区间内查询数字的频率
# 第 268 场周赛
# Q3
# 1702
# 相关标签
# 相关企业
# 提示
# 请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。

# 子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。

# 请你实现 RangeFreqQuery 类：

# RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
# int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
# 一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。

class RangeFreqQuery:
    '''
        下标分组 + 二分查找
    '''
    def __init__(self, arr: List[int]):
        self.pos = defaultdict(list)
        for i, x in enumerate(arr):
            self.pos[x].append(i)


    def query(self, left: int, right: int, value: int) -> int:
        if not self.pos[value]:
            return 0
        idx1 = rightBound(self.pos[value], left)
        idx2 = leftBound(self.pos[value], right)
        if idx1 == -1 or idx2 == -1: 
            return 0
        return idx2 - idx1 + 1