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
    def hanota(self, A: List[int], B: List[int], C: List[int]) -> None:
        """
        Do not return anything, modify C in-place instead.
        """
        def dfs(n: int, A: List[int], B: List[int], C: List[int]) -> None:
            if n == 1:
                C.append(A.pop())
                return
            # A -> C -> B
            dfs(n - 1, A, C, B)
            # A -> B -> C
            dfs(1, A, B, C)
            # B -> A -> C
            dfs(n - 1, B, A, C)
        dfs(len(A),  A, B, C)
