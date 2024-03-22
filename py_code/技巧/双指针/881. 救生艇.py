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
    def numRescueBoats(self, people: List[int], limit: int) -> int:
        people.sort()
        i = 0
        j = len(people) - 1
        ans = 0
        # 1 2 2 3
        while i <= j:
            if i == j:
                ans += 1
                break
            if people[i] + people[j] <= limit:
                ans += 1
                i += 1
                j -= 1
            elif people[i] + people[j] > limit:
                ans += 1
                j -= 1
        return ans