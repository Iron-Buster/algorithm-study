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
'''
https://leetcode.cn/problems/find-the-k-or-of-an-array/
'''
class Solution:
    def findKOr(self, nums: List[int], k: int) -> int:
        cnt = [0] * 32
        for x in nums:
            for j in range(31,-1,-1):
                if x >> j & 1 == 1:
                    cnt[j] += 1
        return sum(1 << i for i,x in enumerate(cnt) if x >= k)
