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



# 1312. 让字符串成为回文串的最少插入次数
# 第 170 场周赛
# Q4
# 1787
# 相关标签
# 相关企业
# 提示
# 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。

# 请你返回让 s 成为回文串的 最少操作次数 。

# 「回文串」是正读和反读都相同的字符串。



class Solution:
    '''
        等价于求s 和 rev(s)的最长公共子序列
    '''
    def minInsertions(self, s: str) -> int:
        n = len(s)
        s1 = s[::-1]
        print(s1)
        s = " " + s
        s1 = " " + s1
        dp = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if s[i] == s1[j]:
                    dp[i][j] = dp[i - 1][j - 1] + 1
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

        return n - dp[n][n]