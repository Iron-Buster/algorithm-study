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

class Solution:
    def minimumLevels(self, possible: List[int]) -> int:
        if possible.count(1) == 0:
            return -1
        n = len(possible)
        s = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            if possible[i] == 1:
                s[i] = s[i+1] + 1
            else:
                s[i] = s[i+1] - 1
        v = 0
        for i in range(n):
            if possible[i] == 1:
                v += 1
            else:
                v -= 1
            if v > s[i+1]:
                return i
        return -1