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
https://leetcode.cn/problems/power-of-four/
'''

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        # 2的偶数次幂mod 3 = 1，2的奇数次幂mod 3 = 2，排除case2即可
        # case1: 16(2^4) % 3 = 1
        # case2: 8(2^3) % 3 = 2 不是4的幂
        return n > 0 and (n & (n - 1)) == 0 and n % 3 == 1