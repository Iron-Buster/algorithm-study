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

# https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/description/

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        # 逆向思维 保留最多的数字不操作 答案就是 len(nums) - mx
        n = len(nums)
        a = sorted(set(nums))
        # 1 2 3 5 6
        ans = l = 0
        for r, x in enumerate(a):
            while a[l] < x - n + 1:
                l += 1
            ans = max(ans, r - l + 1)
        return n - ans

