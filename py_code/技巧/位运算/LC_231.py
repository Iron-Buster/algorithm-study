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



# 231. 2 的幂
# 已解答
# 简单
# 相关标签
# 相关企业
# 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

# 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。

class Solution:
    '''
        lowbit: x & (x - 1)
    '''
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0: return False
        return (n & (n - 1)) == 0