from math import ceil, floor, gcd, factorial, isqrt, sqrt, log2, log
from typing import *



# https://leetcode.cn/problems/number-of-squareful-arrays/

class Solution:
    def numSquarefulPerms(self, nums: List[int]) -> int:
        n = len(nums)
        U = (1<<n) - 1

        def check(x: int) -> bool:
            rt = isqrt(x)
            return rt * rt == x

        @cache
        def dfs(i: int, mask: int) -> int:
            if mask == U: return 1
            pre = nums[i]
            ans = 0
            for j, cur in enumerate(nums):
                if (mask>>j&1) == 0 and check(pre + cur):
                    ans += dfs(j, mask|(1<<j))
            return ans

        res = sum(dfs(i, 1<<i) for i in range(n))
        # 需要去重 3*2*1 
        mp = defaultdict(int)
        for x in nums:
            mp[x] += 1
        for _, cnt in mp.items():
            fac = factorial(cnt)
            res = res // fac
        return res
