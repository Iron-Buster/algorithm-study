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

# https://leetcode.cn/problems/super-pow/description/

class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        k = 0
        for x in b:
            k = k * 10 + x
        return pow(a, k, 1337)