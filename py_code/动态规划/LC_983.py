from typing import List


'''
https://leetcode.cn/problems/minimum-cost-for-tickets/description/
'''

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        st = set(days)
        dp = [0] * (days[-1] + 1)
        for i in range(1, days[-1] + 1):
            if i not in st:
                dp[i] = dp[i-1]
            else:
                x = max(i-1, 0)
                y = max(i-7, 0)
                z = max(i-30, 0)
                dp[i] = min(dp[x] + costs[0], dp[y] + costs[1], dp[z] + costs[2])
        return dp[-1]