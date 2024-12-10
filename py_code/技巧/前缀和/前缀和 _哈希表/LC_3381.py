from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import *
'''
https://leetcode.cn/problems/maximum-subarray-sum-with-length-divisible-by-k/description/
'''
class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        s = [0] + list(accumulate(nums))
        mp = defaultdict(int)
        mp[0] = 0
        ans = -inf
        for i in range(1, n + 1):
            r = i % k
            if r in mp:
                j = mp[r]
                ans = max(ans, s[i] - s[j])
                if s[i] < s[j]:
                    mp[r] = i
            else:
                mp[r] = i
        return ans


print(Solution().maxSubarraySum([1,2], 1))
print(Solution().maxSubarraySum([-1,-2,-3,-4,-5], 4))
print(Solution().maxSubarraySum([-5,1,2,-3,4], 2))
