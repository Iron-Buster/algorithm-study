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
https://leetcode.cn/problems/missing-number/
'''

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        mx = sum(nums)
        mask = 0
        for x in nums:
            if not mask>>x&1:
                mask |= (1<<x)
        for i in range(len(nums)+1):
            if not mask>>i&1:
                return i
        return 0

