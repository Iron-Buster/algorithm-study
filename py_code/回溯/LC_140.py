from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from random import *
from typing import *

# https://leetcode.cn/problems/word-break-ii/

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        n = len(s)
        st = set(wordDict)
        ans = []
        def dfs(i: int, path: List[str]) -> None:
            if i >= n:
                res = " ".join(path)
                ans.append(res)
                return
            for j in range(i, n):
                if s[i:j+1] in st:
                    path.append(s[i:j+1])
                    dfs(j + 1, path)
                    path.pop()
        dfs(0, [])
        return ans
