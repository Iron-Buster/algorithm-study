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
    def minimumSubarrayLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ans = inf
        for i in range(n):
            v = nums[i]
            if v >= k:
                return 1
            for j in range(i + 1, n):
                v = v | nums[j]
                if v >= k:
                    ans = min(ans, j - i + 1)
        return -1 if ans == inf else ans
