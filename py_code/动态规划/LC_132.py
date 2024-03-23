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


# https://leetcode.cn/problems/palindrome-partitioning-ii/description/

class Solution:
    def minCut(self, s: str) -> int:
        n = len(s)
        dp = [0x3f3f3f for _ in range(n + 1)]
        dp[0] = 0
        for i in range(n + 1):
            for j in range(i):
                if s[j:i] == s[j:i][::-1]:
                    dp[i] = _min(dp[i], dp[j] + 1)
        return dp[n] - 1
def _min(a: int, b: int) -> int:
    if a > b:
        return b
    return a


if __name__ == '__main__':
    print(Solution().minCut("aab"))