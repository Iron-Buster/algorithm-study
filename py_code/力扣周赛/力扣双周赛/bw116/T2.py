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



# 100104. 使二进制字符串变美丽的最少修改次数
# 已解答
# 中等
# 相关企业
# 提示
# 给你一个长度为偶数下标从 0 开始的二进制字符串 s 。

# 如果可以将一个字符串分割成一个或者更多满足以下条件的子字符串，那么我们称这个字符串是 美丽的 ：

# 每个子字符串的长度都是 偶数 。
# 每个子字符串都 只 包含 1 或 只 包含 0 。
# 你可以将 s 中任一字符改成 0 或者 1 。

# 请你返回让字符串 s 美丽的 最少 字符修改次数。


class Solution:
    def minChanges(self, s: str) -> int:
        n = len(s)
        ans = 0
        cnt = 1
        for i in range(1, n):
            if s[i] == s[i - 1]:
                cnt += 1
            else:
                if cnt % 2 != 0:
                    ans += 1
                    cnt += 1
                else:
                    cnt = 1
        return ans