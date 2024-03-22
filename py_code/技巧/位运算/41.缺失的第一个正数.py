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
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
'''
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        mask = 0
        n = len(nums)
        for x in nums:
            if x >= 0 and x <= n: # 大于n的数就不要了，不然会MLE
                mask |= (1<<x)
        for i in range(1, n + 2):
            if not mask >> i & 1:
                return i
        return 0