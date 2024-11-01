from typing import List

'''
https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/description/?envType=daily-question&envId=2024-11-01
'''

class Solution:
    def maxEnergyBoost(self, a: List[int], b: List[int]) -> int:
        n = len(a)
        dp = [[0 for _ in range(2)] for _ in range(n)]
        dp[0][0] = a[0]
        dp[0][1] = b[0]
        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], dp[i-2][1] if i-2 >= 0 else 0) + a[i]
            dp[i][1] = max(dp[i-1][1], dp[i-2][0] if i-2 >= 0 else 0) + b[i]
        return max(dp[-1][0], dp[-1][1])

