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

# 136. 只出现一次的数字
# 已解答
# 简单
# 相关标签
# 相关企业
# 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

# 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        v = 0
        for x in nums:
            v ^= x
        return v
    