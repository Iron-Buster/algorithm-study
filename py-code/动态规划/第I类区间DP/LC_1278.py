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




# 1278. 分割回文串 III
# 已解答
# 第 165 场周赛
# Q4
# 1979
# 相关标签
# 相关企业
# 提示
# 给你一个由小写字母组成的字符串 s，和一个整数 k。

# 请你按下面的要求分割字符串：

# 首先，你可以将 s 中的部分字符修改为其他的小写英文字母。
# 接着，你需要把 s 分割成 k 个非空且不相交的子串，并且每个子串都是回文串。
# 请返回以这种方式分割字符串所需修改的最少字符数


class Solution:
    '''
        第I类区间DP
    '''
    def palindromePartition(self, s: str, k: int) -> int:
        N = len(s)
        K = k
        s = " " + s
        # dp[i][k]表示将s[1:i]分成k个回文子串的最小修改字符数
        dp = [[0 for _ in range(K + 1)] for _ in range(N + 1)]
        def calc(j: int, i: int) -> int:
            cnt = 0
            while j < i:
                cnt += s[j] != s[i]
                j += 1
                i -= 1
            return cnt
        # step1: 初始化k=1
        for i in range(1, N + 1):
            dp[i][1] = calc(1, i)
        # step2: 写出第I类区间DP框架
        for i in range(1, N + 1):
            for k in range(2, min(i, K) + 1):
                dp[i][k] = inf
                for j in range(i, k - 1, -1):
                    dp[i][k] = min(dp[i][k], dp[j - 1][k - 1] + calc(j, i)) 
        return dp[N][K]
                       