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

'''
https://leetcode.cn/problems/palindrome-number/
'''
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        t = x
        v = 0
        while x:
            v = v * 10 + x % 10
            x = x // 10
        return v == t