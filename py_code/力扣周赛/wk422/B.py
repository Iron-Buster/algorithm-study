import heapq
from typing import *

'''
https://leetcode.cn/contest/weekly-contest-422/problems/find-minimum-time-to-reach-last-room-i/
'''

dris = [(1, 0), (0, 1), (-1, 0), (0, -1)]
class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        dp = [[float('inf')] * m for _ in range(n)]
        dp[0][0] = 0
        q = [(0, 0, 0)]
        while q:
            cur, x, y = heapq.heappop(q)
            if cur > dp[x][y]:
                continue
            for dx, dy in dris:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    ntime = cur + max(0, moveTime[nx][ny] - cur) + 1
                    if ntime < dp[nx][ny]:
                        dp[nx][ny] = ntime
                        heapq.heappush(q, (ntime, nx, ny))

        return dp[n-1][m-1]