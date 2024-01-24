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
# 二分找右边界 返回最后一个大于等于t的下标
def leftBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l
                                
# 二分找左边界 返回第一个大于等于t的下标
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r) >> 1
        if a[mid] < t:
            l = mid + 1
        else:
            r = mid 
    return -1 if a[l] < t else l
    

# 2540. 最小公共值
# 已解答
# 第 96 场双周赛
# Q1
# 1250
# 相关标签
# 相关企业
# 提示
# 给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。

# 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的

class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        cnt = Counter(nums1)
        for x in nums2:
            if cnt[x] > 0: return x
        return -1