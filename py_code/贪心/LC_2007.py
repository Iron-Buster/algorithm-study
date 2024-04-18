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






# https://leetcode.cn/problems/find-original-array-from-doubled-array/?envType=daily-question&envId=2024-04-18



class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        changed.sort()
        ans = []
        cnt = Counter()
        for x in changed:
            if x not in cnt:
                cnt[x * 2] += 1
                ans.append(x)
            else:
                cnt[x] -= 1
                if cnt[x] == 0:
                    del cnt[x]

        return [] if cnt else ans