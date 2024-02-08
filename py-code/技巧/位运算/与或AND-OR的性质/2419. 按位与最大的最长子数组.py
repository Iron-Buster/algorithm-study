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
https://leetcode.cn/problems/longest-subarray-with-maximum-bitwise-and/
'''
class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        ans = 0
        mx = max(nums)
        # bit位都为1 AND的值才会变大 数组中跟最大值AND才是我们想要的
        # 得出结论 -> 数组中最大值连续出现的次数
        j = -1
        for i,x in enumerate(nums):
            if x == mx:
                ans = max(ans, i - j)
            else:
                j = i
        return ans