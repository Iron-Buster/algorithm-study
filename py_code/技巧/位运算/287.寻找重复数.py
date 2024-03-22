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
    def findDuplicate(self, nums: List[int]) -> int:
        mask = 0
        for x in nums:
            if (mask>>x&1):
                return x
            mask |= (1<<x)
        return 0