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


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2:
            return False
        t = s // 2
        @cache
        def f(i: int, v: int) -> bool:
            if i >= len(nums): return v == 0
            if v < 0: return False
            return f(i+1, v) or f(i+1, v-nums[i])
        return f(0, t)


if __name__ == '__main__':
    print(Solution().canPartition([1, 5, 11, 5]))