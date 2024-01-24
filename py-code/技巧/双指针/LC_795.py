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


# 795. 区间子数组个数
# 已解答
# 中等
# 相关标签
# 相关企业
# 给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。

# 生成的测试用例保证结果符合 32-bit 整数范围

class Solution:
    '''
        最大元素在[left, right]内的子数组个数
        等价于最大元素小于right的子数组个数 - 最大元素小于left - 1的子数组个数
    '''
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:

        def calc(a: List[int], limit: int) -> int:
            ans = 0
            j = 0
            for i, x in enumerate(a):
                if x > limit:
                    j = i + 1
                else:
                    ans += i - j + 1
            return ans
        return calc(nums, right) - calc(nums, left - 1)