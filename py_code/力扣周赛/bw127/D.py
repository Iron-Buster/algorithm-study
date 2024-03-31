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
    def sumOfPowers(self, nums: List[int], k: int) -> int:
        # i是当前下标
        # j是还需要选多少个数
        # pre是上一个选的数
        # min_diff是目前选的数的能量值
        nums.sort()
        @cache
        def dfs(i: int, j: int, pre: int, min_diff: int) -> int:
            if j > i + 1:
                return 0
            if j == 0:
                return min_diff
            res1 = dfs(i - 1, j, pre, min_diff) # 不选
            res2 = dfs(i - 1, j - 1, nums[i], min(min_diff, pre - nums[i])) # 选
            return (res1 + res2) % MOD

        return dfs(len(nums) - 1, k, inf, inf)


