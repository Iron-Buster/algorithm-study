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

# 第 197 场周赛
# Q1
# 1161
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 nums 。

# 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。

# 返回好数对的数目。

class Solution:
    def numIdenticalPairs(self, nums: List[int]) -> int:
        ans = 0
        for i, x in enumerate(nums):
            for j, y in enumerate(nums):
                if x == y and i < j:
                    ans += 1
        return ans