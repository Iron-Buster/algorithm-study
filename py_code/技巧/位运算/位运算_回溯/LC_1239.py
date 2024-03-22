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


# 1239. 串联字符串的最大长度
# 第 160 场周赛
# Q3
# 1720
# 相关标签
# 相关企业
# 提示
# 给定一个字符串数组 arr，字符串 s 是将 arr 的含有 不同字母 的 子序列 字符串 连接 所得的字符串。

# 请返回所有可行解 s 中最长长度。

# 子序列 是一种可以从另一个数组派生而来的数组，通过删除某些元素或不删除元素而不改变其余元素的顺序。

class Solution:
    def maxLength(self, arr: List[str]) -> int:        
        # 预处理一下没用的字符串
        ss = []
        for s in arr:
            mask = 0
            ok = True
            for ch in s:
                x = ord(ch) - 97
                if (mask >> x & 1) == 1:
                    ok = False
                    break
                mask |= (1 << x)
            if ok: 
                ss.append(s)
        n = len(ss)
   
        def dfs(i: int, mask: int) -> int:
            if i >= n: return 0
            # 不选第i个
            a = dfs(i + 1, mask)
            # 判断能不能选第i个
            s = 0
            for ch in ss[i]:
                x = ord(ch) - 97
                s |= (1 << x)
            b = 0
            if not (mask & s):  # 两个集合没有交集，选第i个
                mask |= s
                b = dfs(i + 1, mask) + len(ss[i])
            else:               # 只能不选
                b = dfs(i + 1, mask)
            return max(a, b)
        
        return dfs(0, 0)

def solve():
    ans = Solution().maxLength(["aa", "bb"])
    print(ans)

solve()