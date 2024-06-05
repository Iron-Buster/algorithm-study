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



class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x:x[0])
        start = 1
        end = 0
        for s, e in meetings:
            if s > end:
                days -= end - start + 1
                start = s
            end = max(end, e)
        days -= end - start + 1
        return days
