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

# 747. 至少是其他数字两倍的最大数
# 已解答
# 第 64 场周赛
# Q1
# 1189
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。

# 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 


class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        mx = max(nums)
        ans = -1
        for i, x in enumerate(nums):
            if x == mx:
                ans = i
                continue
            if x * 2 > mx: return -1
        return ans