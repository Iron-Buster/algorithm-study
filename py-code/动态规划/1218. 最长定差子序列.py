from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from random import *
from typing import *
import random
import sys
import os
from io import BytesIO, IOBase
from copy import deepcopy
import threading

BUFSIZE = 4096
MOD = 10 ** 9 + 7
mod = 998244353
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))

class Solution:
    def longestSubsequence(self, arr: List[int], d: int) -> int:
        mp = defaultdict(int)
        ans = 1
        for i, x in enumerate(arr):
            if mp[x-d]:
                mp[x] = mp[x-d] + 1
                ans = max(ans, mp[x])
            else:
                mp[x] = 1
        return ans