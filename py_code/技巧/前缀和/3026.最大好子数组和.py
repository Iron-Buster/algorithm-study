from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from random import *
from typing import *
import random
import sys
import os
from io import BytesIO, IOBase
from copy import deepcopy
import threading

BUFSIZE = 4096
MOD = 10 ** 9 + 7
mod = 998244353
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))

'''
https://leetcode.cn/problems/maximum-good-subarray-sum/description/
哈希表维护当前x-pos的前缀和最小值，
然后前缀和更新答案
'''

class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        s = PF(nums)
        g = {}
        for i, x in enumerate(nums):
            if x in g:
                if s[g[x]] > s[i]:
                    g[x] = i
            else:
                g[x] = i
        print(g)
        ans = -inf
        for i, x in enumerate(nums):
            if (x - k) in g:
                ans = max(ans, s[i+1] - s[g[x-k]])
            if (x + k) in g:
                ans = max(ans, s[i+1] - s[g[x+k]])
        return 0 if ans == -inf else ans

if __name__ == '__main__':
    print(Solution().maximumSubarraySum([-1,-2,-3,-4], 2))