from typing import List




'''
https://leetcode.cn/problems/node-with-highest-edge-score/description/?envType=daily-question&envId=2024-09-21
'''
class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        n = len(edges)
        cnt = [0] * n
        mx = 0
        ans = n + 1
        for u, v in enumerate(edges):
            cnt[v] += u
            if cnt[v] > mx:
                mx = cnt[v]
                ans = v
            elif cnt[v] == mx:
                ans = min(ans, v)
        return ans

