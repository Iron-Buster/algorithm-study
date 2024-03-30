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
        ans = inf
        for i, x in enumerate(nums):
            for j in range(i - 1, -1, -1):
                if (nums[j] | x) == nums[j]:
                    break
                nums[j] |= x
                if nums[j] >= k:
                    ans = min(ans, i - j)
        return -1 if ans == inf else ans