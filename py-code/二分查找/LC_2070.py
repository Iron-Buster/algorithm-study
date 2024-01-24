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
    

# 2070. 每一个查询的最大美丽值
# 第 65 场双周赛
# Q3
# 1724
# 相关标签
# 相关企业
# 提示
# 给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。

# 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。

# 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。


# 二分找右边界
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l
    
class Solution:
    '''
        排序 + 二分
    '''
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        n = len(items)
        idx = [0] * n
        price = [0] * n
        for i in range(n):
            idx[i] = i
            price[i] = items[i][0]
        price.sort()
        idx.sort(key=lambda x: items[x][0])
        max_b = [0] * n                 # 预处理max_beauty 为一段区间的最大的美丽值
        max_b[0] = items[idx[0]][1]
        for i in range(1, n):
            max_b[i] = max(max_b[i - 1], items[idx[i]][1])
        print(max_b)
        ans = []
        for q in queries:
            index = rightBound(price, q)
            if index == -1:
                ans.append(0)
            else:
                ans.append(max_b[index])
        return ans
