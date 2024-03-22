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


# https://leetcode.cn/problems/validate-stack-sequences/description/

class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        j = 0
        stk = []
        for x in pushed:
            stk.append(x)
            while stk and stk[-1] == popped[j]:
                stk.pop()
                j += 1
        while stk and stk[-1] == popped[j]:
            stk.pop()
            j += 1
        return len(stk) == 0
