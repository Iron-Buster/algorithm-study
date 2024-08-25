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

# https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/description/?envType=daily-question&envId=2024-08-25
class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        s = sum(nums)
        if s % k != 0: return False
        avg = s // k
        nums.sort()

        U = (1 << n) - 1

        @cache
        def dfs(s: int, t: int) -> bool:
            if s == U: return True
            for i in range(n):
                if s >> i & 1 == 1:
                    continue
                if t + nums[i] > avg:
                    break
                if dfs(s | (1 << i), (t + nums[i]) % avg):
                    return True
            return False

        return dfs(0, 0)