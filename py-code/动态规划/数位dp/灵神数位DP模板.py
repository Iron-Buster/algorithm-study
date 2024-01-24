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






'''
    数位DP 通用模板 v2.0
    [0, n]
    [low, high] f(high) - f(low-1)
'''

class Solution:
    def numberOfPowerfulInt(self, start: int, finish: int, limit: int, s: str) -> int:
        low = str(start)
        high = str(finish)
        n = len(high)
        low = '0' * (n - len(low)) + low
        diff = n - len(s)


        # 基础版：不考虑前导零
        # @cache
        # def dfs(i: int, limit_low: bool, limit_high: bool) -> int:
        #     if i == n:
        #         return 1
        #     # 第 i个数位枚举的范围
        #     # 如果对数位有其他约束，应该在下面的for循环做限制
        #     lo = int(low[i]) if limit_low else 0
        #     hi = int(high[i]) if limit_high else 9

        #     res = 0
        #     if i < diff:
        #         for d in range(lo, min(hi, limit)+1):
        #             res += dfs(i + 1, limit_low and d == lo, limit_high and d == hi)
        #     else:
        #         # 必需填 int(s[i-diff])
        #         x = int(s[i-diff])
        #         if lo <= x <= min(hi, limit):
        #             res = dfs(i + 1, limit_low and d == lo, limit_high and d == hi)
        #     return res

        # 扩展版：支持前导零
        # is_num：前面是否填了非零数字
        @cache
        def dfs(i: int, limit_low: bool, limit_high: bool, is_num: bool) -> int:
            if i == n:
                return 1 if is_num else 0
    
            res = 0
            if not is_num and low[i] == '0':  # 前面填的都是0，limit_low 一定是true
                if i < diff:
                    # 这一位也可以填 0
                    res += dfs(i + 1, True, False, False)
            
            # 第 i个数位枚举的范围
            # 如果对数位有其他约束，应该在下面的for循环做限制
            lo = int(low[i]) if limit_low else 0
            hi = int(high[i]) if limit_high else 9

            d0 = 1 if is_num else 1
            if i < diff:
                for d in range(max(lo, d0), min(hi, limit)+1):
                    res += dfs(i + 1, limit_low and d == lo, limit_high and d == hi, False)
            else:
                # 必需填 int(s[i-diff])
                x = int(s[i-diff])
                if max(lo, d0) <= x <= min(hi, limit):
                    res = dfs(i + 1, limit_low and d == lo, limit_high and d == hi, False)
            return res
        
        return dfs(0, True, True, False)























