
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
    def numOfSubarrays(self, arr: List[int]) -> int:
        f0 = 0
        f1 = 0
        if arr[0] % 2 == 1:
            f1 = 1
        else:
            f0 = 1
        ans = f1
        for i in range(1, len(arr)):
            if arr[i] % 2 == 0:
                f0 = f0 + 1
            else:
                f0_new = f1
                f1_new = f0 + 1
                f0 = f0_new
                f1 = f1_new
            ans += f1
        return ans % MOD

    def numOfSubarrays2(self, arr: List[int]) -> int:
        n = len(arr)
        dp = [[0] * 2 for i in range(n)]
        # dp[i][0] 表示和为偶数的子数组个数
        # dp[i][1] 表示和为奇数的子数组个数
        if arr[0] % 2 == 1:
            dp[0][1] = 1
        else:
            dp[0][0] = 1
        ans = dp[0][1]
        for i in range(1, n):
            if arr[i] % 2 == 0:
                dp[i][0] = dp[i - 1][0] + 1  # 偶数 + 偶数 = 偶数
                dp[i][1] = dp[i - 1][1]  # 奇数 + 偶数 = 奇数
            else:
                dp[i][0] = dp[i - 1][1]  # 奇数 + 奇数 = 偶数
                dp[i][1] = dp[i - 1][0] + 1  # 偶数 + 奇数 = 奇数
            ans += dp[i][1]

        return ans % MOD


