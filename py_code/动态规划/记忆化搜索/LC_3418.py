from functools import cache
from typing import List

# https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn

class Solution:
    def maximumAmount(self, coins: List[List[int]]) -> int:
        m = len(coins)
        n = len(coins[0])

        @cache
        def dfs(i: int, j: int, k: int) -> int:
            if i >= m or j >= n: return -0x3f3f3f3f
            if i == m - 1 and j == n - 1:
                if coins[i][j] >= 0 or k == 0: return coins[i][j]
                else: return 0
            ans = -0x3f3f3f3f
            ans = max(ans, dfs(i + 1, j, k) + coins[i][j])
            ans = max(ans, dfs(i, j + 1, k) + coins[i][j])
            # 感化
            if coins[i][j] < 0 and k:
                ans = max(ans, dfs(i + 1, j, k - 1))
                ans = max(ans, dfs(i, j + 1, k - 1))
            return ans
        return dfs(0, 0, 2)