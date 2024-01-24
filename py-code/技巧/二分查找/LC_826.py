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


# 826. 安排工作以达到最大收益
# 第 82 场周赛
# Q3
# 1709
# 相关标签
# 相关企业
# 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:

# difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
# worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
# 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。

# 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
# 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。


class Solution:
    '''
        排序 + 二分
    '''
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        n = len(difficulty)
        idx = [0] * n
        for i in range(n):
            idx[i] = i
        idx.sort(key=lambda x: difficulty[x])
        difficulty.sort()
        max_profit = [0] * n             # 预处理max_profit数组，维护当前i的最大报酬
        max_profit[0] = profit[idx[0]]
        for i in range(1, n):
            j = idx[i]
            max_profit[i] = max(max_profit[i - 1], profit[j])         
        ans = 0
        for w in worker:
            index = leftBound(difficulty, w)
            if index == -1: continue
            ans += max_profit[index]
        return ans

