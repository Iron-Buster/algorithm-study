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


# 1781. 所有子字符串美丽值之和
# 第 47 场双周赛
# Q3
# 1715
# 相关标签
# 相关企业
# 提示
# 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。

# 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
# 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。

class Solution:
    '''
        s最长不超过500 暴力枚举
    '''
    def beautySum(self, s: str) -> int:
        n = len(s)
        ans = 0
        for i in range(n):
            cnt = Counter()
            for j in range(i, n):
                cnt[s[j]] += 1
                ans += max(cnt.values()) - min(cnt.values())
        return ans