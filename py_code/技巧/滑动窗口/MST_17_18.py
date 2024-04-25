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



# https://leetcode.cn/problems/shortest-supersequence-lcci/description/
class Solution:
    def shortestSeq(self, big: List[int], small: List[int]) -> List[int]:
        ans_left, ans_right = -1, 100001
        cnt_s = Counter(small)
        cnt = len(small)
        j = 0
        for i, x in enumerate(big):
            if cnt_s[x] > 0:
                cnt -= 1
            cnt_s[x] -= 1
            if cnt == 0:
                while j < i and cnt_s[big[j]] < 0:
                    cnt_s[big[j]] += 1
                    j += 1
                if i - j < ans_right - ans_left:
                    ans_left, ans_right = j, i
                cnt_s[big[j]] += 1
                j += 1
                cnt += 1
        if ans_left == -1 or ans_right == 100001:
            return []
        return [ans_left, ans_right]

