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
https://leetcode.cn/problems/binary-number-with-alternating-bits/
'''

class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        pre = -1
        while n:
            cur = n & 1
            if pre ^ cur == 0:
                return False
            pre = cur
            n >>= 1
        return True