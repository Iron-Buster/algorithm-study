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

# 137. 只出现一次的数字 II
# 已解答
# 中等
# 相关标签
# 相关企业
# 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

# 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for i in range(32):
            cnt = sum((x >> i) & 1 for x in nums)
            if cnt % 3 == 1:
                if i == 31:
                    ans -= (1 << i)
                else:
                    ans |= (1 << i)
        return ans