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

def lowbit(x: int) -> int:
    return x & -x

class Solution:
    def minOperations(self, n: int) -> int:
        @cache
        def dfs(x: int) -> int:
            if x & (x-1) == 0: return 1
            lb = lowbit(x)
            return min(dfs(x - lb), dfs(x + lb)) + 1
        return dfs(n)

if __name__ == '__main__':
    print(Solution().minOperations(39))