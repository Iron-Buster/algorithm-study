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
https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/
'''

class Solution:
    def minFlips(self, a: int, b: int, c: int) -> int:
        ans = 0
        for i in range(31,-1,-1):
            if c >> i & 1 == 1:
                if (a >> i & 1) != 1 and (b >> i & 1) != 1:
                    ans += 1
            else:
                if a >> i & 1 == 1:
                    ans += 1
                if b >> i & 1 == 1:
                    ans += 1
        return ans