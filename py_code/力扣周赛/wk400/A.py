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
    def minimumChairs(self, s: str) -> int:
        ans = 0
        res = 0
        for c in s:
            if c == 'E':
                ans += 1
            else:
                ans -= 1
            res = max(res, ans)
        return res