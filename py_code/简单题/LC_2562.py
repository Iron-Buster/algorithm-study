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

# 2562. 找出数组的串联值
# 已解答
# 第 332 场周赛
# Q1
# 1260
# 相关标签
# 相关企业
# 提示
# 给你一个下标从 0 开始的整数数组 nums 。

# 现定义两个数字的 串联 是由这两个数值串联起来形成的新数字。

# 例如，15 和 49 的串联是 1549 。
# nums 的 串联值 最初等于 0 。执行下述操作直到 nums 变为空：

# 如果 nums 中存在不止一个数字，分别选中 nums 中的第一个元素和最后一个元素，将二者串联得到的值加到 nums 的 串联值 上，然后从 nums 中删除第一个和最后一个元素。
# 如果仅存在一个元素，则将该元素的值加到 nums 的串联值上，然后删除这个元素。
# 返回执行完所有操作后 nums 的串联值


class Solution:
    '''
        双指针
    '''
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        i = 0
        j = len(nums) - 1
        ans = 0
        while i < j:
            v = str(nums[i]) + str(nums[j])
            ans += int(v)
            i += 1
            j -= 1
        if i == j: ans += nums[i]
        return ans