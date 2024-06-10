from collections import deque
from typing import *


# https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/description/


class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        win_cnt = Counter()
        mx = skills[0]
        mx_index = 0
        q = deque()
        for i in range(len(skills)):
            q.append(i)
            if skills[i] > mx:
                mx = skills[i]
                mx_index = i
        while True:
            i = q.popleft()
            j = q.popleft()
            if win_cnt[i] >= k: return i
            if win_cnt[j] >= k: return j
            if i == mx_index or j == mx_index: return mx_index
            if skills[i] > skills[j]:
                win_cnt[i] += 1
                win_cnt[j] = 0
                q.appendleft(i)
                q.append(j)
            else:
                win_cnt[j] += 1
                win_cnt[i] = 0
                q.appendleft(j)
                q.append(i)
        return 0        
