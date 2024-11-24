'''

https://leetcode.cn/problems/rearrange-k-substrings-to-form-target-string/description/
'''
from collections import defaultdict


class Solution:
    def isPossibleToRearrange(self, s: str, t: str, k: int) -> bool:
        n = len(s)
        m = n // k
        cnt = defaultdict(str)

        for i in range(0, n, m):
            v = s[i:i+m]
            cnt[v] += 1
        for i in range(0, n, m):
            v = t[i:i+m]
            if not cnt[v]:
                return False
            cnt[v] -= 1
            if cnt[v] == 0: del cnt[v]
        return True

