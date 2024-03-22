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
https://leetcode.cn/problems/perfect-squares/?envType=study-plan-v2&envId=dynamic-programming
'''

class Solution:
    def numSquares(self, n: int) -> int:
        f = [0] * (n + 1)
        f[1] = 1
        for i in range(2, n+1):
            j = 1
            f[i] = 0x3f3f3f
            while j * j <= i:
                f[i] = min(f[i], f[i-j*j] + 1)
                j += 1
        return f[n]