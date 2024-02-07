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
https://leetcode.cn/problems/number-complement/
'''


class Solution:
    def findComplement(self, num: int) -> int:
        # 构造长度等于num的一个二进制位全1的数字v，然后异或即可
        t, v = num, 0
        while t:
            t = (t >> 1)
            v = (v << 1) | 1
        return num ^ v