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

# https://leetcode.cn/problems/heaters/description/
class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        houses.sort()
        heaters.sort()
        l = 0
        r = 10 ** 9
        def check(mid: int) -> int:
            i = j = 0
            while i < len(houses) and j < len(heaters):
                if abs(houses[i] - heaters[j]) <= mid:
                    i += 1
                else:
                    j += 1
            return i >= len(houses)

        while l < r:
            mid = l + r + 1 >> 1
            if check(mid):
                r = mid - 1
            else:
                l = mid
        return l
