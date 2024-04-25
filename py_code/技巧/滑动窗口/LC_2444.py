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

# https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/description/

class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        ans = 0
        min_i = max_i = i0 = -1
        for i, x in enumerate(nums):
            if x == minK: min_i = i
            if x == maxK: max_i = i
            if x < minK or x > maxK: i0 = i
            p = _min(min_i, max_i)
            if i0 < p:
                ans += p - i0
        return ans

def _min(a: int, b: int) -> int:
    return a if a < b else b


def _max(a: int, b: int) -> int:
    return a if a > b else b