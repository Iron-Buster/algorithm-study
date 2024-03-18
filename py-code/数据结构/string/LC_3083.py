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
    def isSubstringPresent(self, s: str) -> bool:
        t = s[::-1]
        for i in range(len(s) - 1):
            sub = s[i:i+2]
            if len(sub) == 2 and sub in t:
                return True
        return False

