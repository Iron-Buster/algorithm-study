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



MOD = 10 ** 9 + 7
class Solution:
    def maxFrequencyScore(self, nums: List[int], k: int) -> int:
        cnt = Counter()
        ans = s = j = 0
        for i in range(len(nums)):
            cnt[nums[i]] += 1
            if cnt[nums[i]] == 1:
                s += pow(nums[i], 2)
            if i - j + 1 > k:
                cnt[nums[j]] -= 1
                if cnt[nums[j]] == 0:
                    s -= pow(nums[j], 2)
                    del cnt[nums[j]]
                    j += 1
            ans = max(ans, s)
        return ans % MOD