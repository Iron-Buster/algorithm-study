from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))

# https://leetcode.cn/problems/reverse-integer/description/

class Solution:
    def reverse(self, x: int) -> int:
        flag = False
        if x < 0:
            flag = True
        x = abs(x)
        t = 0
        while x:
            t = t * 10 + x % 10
            x //= 10
        if t > 2 ** 31 - 1:
            return 0
        return -t if flag else t
