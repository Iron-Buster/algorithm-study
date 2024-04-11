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


# https://leetcode.cn/problems/greatest-sum-divisible-by-three/description/


class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        # (a+b)%p = (a%p+b%p)%p
        @cache
        def dfs(i: int, m: int) -> int:
            if i >= len(nums):
                return 0 if m == 0 else -inf
            # 不选
            a = dfs(i + 1, m)
            # 选
            b = dfs(i + 1, (m + nums[i]) % 3) + nums[i]
            return max(a, b)
        return dfs(0, 0)