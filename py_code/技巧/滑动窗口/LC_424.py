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





# 424. 替换后的最长重复字符
# 中等
# 相关标签
# 相关企业
# 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。

# 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        cnt = Counter()
        mx = 0
        ans = j = 0
        for i, x in enumerate(s):
            cnt[x] += 1
            mx = max(mx, cnt[x])
            if i - j + 1 > mx + k:
                left = s[j]
                cnt[left] -= 1
                if cnt[left] == 0: 
                    del cnt[left]
                j += 1
            ans = max(ans, i - j + 1)
        return ans