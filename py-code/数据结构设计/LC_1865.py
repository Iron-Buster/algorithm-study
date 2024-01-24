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



# 1865. 找出和为指定值的下标对
# 第 241 场周赛
# Q3
# 1681
# 相关标签
# 相关企业
# 提示
# 给你两个整数数组 nums1 和 nums2 ，请你实现一个支持下述两类查询的数据结构：

# 累加 ，将一个正整数加到 nums2 中指定下标对应元素上。
# 计数 ，统计满足 nums1[i] + nums2[j] 等于指定值的下标对 (i, j) 数目（0 <= i < nums1.length 且 0 <= j < nums2.length）。
# 实现 FindSumPairs 类：

# FindSumPairs(int[] nums1, int[] nums2) 使用整数数组 nums1 和 nums2 初始化 FindSumPairs 对象。
# void add(int index, int val) 将 val 加到 nums2[index] 上，即，执行 nums2[index] += val 。
# int count(int tot) 返回满足 nums1[i] + nums2[j] == tot 的下标对 (i, j) 数目


class FindSumPairs:
    
    def __init__(self, a: List[int], b: List[int]):
        self.a = a
        self.b = b
        self.cnt_b = Counter(b) # 保存b每个元素出现的次数


    def add(self, index: int, val: int) -> None:
        v = self.b[index]
        self.cnt_b[v] -= 1      # 老值出现次数 -1, 新值出现次数 + 1
        self.cnt_b[v + val] += 1
        self.b[index] += val

    def count(self, tot: int) -> int:
        # 两数之和
        return sum(self.cnt_b[tot - x] for x in self.a)


# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)