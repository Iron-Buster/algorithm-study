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

# 658. 将 x 减到 0 的最小操作数
# 已解答
# 第 215 场周赛
# Q3
# 1817
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。

# 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。



class Solution:
    '''
        前缀后缀和 + 二分查找
        1.x可能等于某个前缀和
        2.x可能等于某个后缀和
        3.x可能等于某个前缀和 + 后缀和 (枚举前缀和, 二分查找这个后缀和)
    '''
    def minOperations(self, nums: List[int], x: int) -> int:
        n = len(nums)
        pre = PF(nums)   
        suf = SUF(nums)
        if pre[n] < x: return -1
        ans = inf
        l, r = 0, n
        # x可能等于某个后缀和
        while l <= r:
            mid = (l + r) >> 1
            if suf[mid] > x: 
                l = mid + 1
            elif suf[mid] < x: 
                r = mid - 1
            else: 
                ans = min(ans, n - mid)
                break
        for i in range(1, n + 1):
            if pre[i] == x: # x可能等于某个前缀和
                ans = min(ans, i)
                break
            # x可能等于某个前缀和 + 后缀和 二分找这个后缀
            target = x - pre[i]
            l, r = 0, n
            while l <= r:
                mid = (l + r) >> 1
                if suf[mid] > target:
                    l = mid + 1
                elif suf[mid] < target:
                    r = mid - 1
                else:
                    ans = min(ans, i + (n - mid))   
                    break
        return -1 if ans == inf else ans
            