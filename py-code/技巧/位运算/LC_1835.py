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

# 1835. 所有数对按位与结果的异或和
# 已解答
# 第 237 场周赛
# Q4
# 1825
# 相关标签
# 相关企业
# 提示
# 列表的 异或和（XOR sum）指对所有元素进行按位 XOR 运算的结果。如果列表中仅有一个元素，那么其 异或和 就等于该元素。

# 例如，[1,2,3,4] 的 异或和 等于 1 XOR 2 XOR 3 XOR 4 = 4 ，而 [3] 的 异或和 等于 3 。
# 给你两个下标 从 0 开始 计数的数组 arr1 和 arr2 ，两数组均由非负整数组成。

# 根据每个 (i, j) 数对，构造一个由 arr1[i] AND arr2[j]（按位 AND 运算）结果组成的列表。其中 0 <= i < arr1.length 且 0 <= j < arr2.length 。

# 返回上述列表的 异或和 。

class Solution:
    # def getXORSum(self, a: List[int], b: List[int]) -> int:
    #     ans = 0
    #     for k in range(32, -1, -1):
    #         # 统计每一个为上 1的个数
    #         cnt1 = sum(1 for num in a if num >> k & 1)
    #         cnt2 = sum(1 for num in b if num >> k & 1)
    #         # 两个都为1
    #         if cnt1 % 2 == 1 and cnt2 % 2 == 1:
    #             ans |= (1 << k)
    #     return ans
    '''
        式子化简
        arr1[a,b]
        arr2[c,d]
        = (a & c) ^ (a & d) ^ (b & c) ^ (b & d) -> 分别提出 a, b
        = (a & (c ^ d)) ^ (b & (c ^ d))         -> 提出(c ^ d)
        = (c ^ d) & (a ^ b) 
    '''
    def getXORSum(self, arr1: List[int], arr2: List[int]) -> int:
        v1 = 0
        v2 = 0
        for x in arr1: v1 ^= x
        for x in arr2: v2 ^= x
        return v1 & v2
    
