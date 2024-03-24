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
    def frequencySort(self, s: str) -> str:
        cnt = Counter(s)
        return "".join([k * v for k, v in sorted(cnt.items(), key=lambda x:-x[1])])