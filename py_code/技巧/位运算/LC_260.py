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

# 260. 只出现一次的数字 III
# 已解答
# 中等
# 相关标签
# 相关企业
# 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

# 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。


class Solution:
    '''
        只有两个数不相同, 假设这两个数为x, y
        nums异或的结果 = x ^ y
        设x ^ y = k 因为x!=y, 那么k一定不为0
        如果k的二进制第n位为1, 那么x的二进制第n位等于0并且y的二进制第n等于1, 或者x的二进制第n位等于1并且y的二进制第n等    
    '''
    def singleNumber(self, nums: List[int]) -> List[int]:
        k = 0
        for x in nums: k ^= x
        lowbit = k & -k
        x = 0
        for num in nums:
            if (num & lowbit) == 0:
                x ^= num
        return [x, k ^ x]