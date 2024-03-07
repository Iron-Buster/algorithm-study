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
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        v = 0
        ans = [0] * len(word)
        for i, x in enumerate(word):
            v = ((v * 10 + int(x)) % m + m) % m
            if v == 0:
                ans[i] = 1
        return ans