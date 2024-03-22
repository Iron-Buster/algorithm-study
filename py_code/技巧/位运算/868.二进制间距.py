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
https://leetcode.cn/problems/binary-gap/
'''

class Solution:
    def binaryGap(self, n: int) -> int:
        j = -1
        ans = 0
        for i in range(31,-1,-1):
            if n >> i & 1 == 1:
                if j != -1:
                    ans = max(ans, j - i)
                j = i
        return ans