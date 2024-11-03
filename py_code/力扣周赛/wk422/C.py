import heapq
from typing import *

'''
https://leetcode.cn/contest/weekly-contest-422/problems/find-minimum-time-to-reach-last-room-ii/
'''

dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n = len(moveTime)
        m = len(moveTime[0])
        dp = [[float('inf')] * m for _ in range(n)]
        dp[0][0] = 0
        q = [(0, 0, 0, 0)]
        while q:
            cur, x, y, cnt = heapq.heappop(q)
            if cur > dp[x][y]:
                continue
            for dx, dy in dirs:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m:
                    wait = max(0, moveTime[nx][ny] - cur)
                    move = 1 if cnt % 2 == 0 else 2
                    ntime = cur + wait + move
                    ncnt = cnt + 1
                    if ntime < dp[nx][ny]:
                        dp[nx][ny] = ntime
                        heapq.heappush(q, (ntime, nx, ny, ncnt))

        return dp[n - 1][m - 1]

