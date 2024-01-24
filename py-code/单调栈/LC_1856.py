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



class Solution:
    '''
        对于每一个nums[i]
        用单调栈求出nums[i]能够作为最小值的最长区间 [L,R]
        然后预处理出前缀和数组sum
        然后枚举每一个nums[i]作为 min(nums[i:j]) * sum[i:j] 的答案，取一个最大的
    '''
    def maxSumMinProduct(self, a: List[int]) -> int:
        n = len(a)
        left = [0] * (n+1)
        right = [0] * (n+1)
        s = PF(a)
        stk = deque()
        stk.append(-1)
        for i in range(n):
            while len(stk) > 1 and a[stk[0]] >= a[i]:
                stk.popleft()
            left[i] = stk[0]
            stk.appendleft(i)
        stk.clear()
        stk.append(n)
        for i in range(n-1,-1,-1):
            print(stk)
            while len(stk) > 1 and a[stk[0]] >= a[i]:
                stk.popleft()
            right[i] = stk[0]
            stk.appendleft(i)
        ans = 0
        for i, x in enumerate(a):
            l = left[i]
            r = right[i]
            ans = max(ans, x * (s[r] - s[l+1]))
        return ans % MOD