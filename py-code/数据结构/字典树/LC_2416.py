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
def SUF(a):
    n = len(a)
    suf = [0] * (n + 1)
    for i in range(n - 1, -1, -1):
        suf[i] = suf[i + 1] + a[i]
    return suf
# 返回<=t的最后一个下标
def leftBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r + 1) >> 1
        if a[mid] > t:
            r = mid - 1
        else:
            l = mid
    return -1 if a[l] > t else l
                                
# 返回>=t的第一个下标
def rightBound(a: List[int], t: int) -> int:
    l, r = 0, len(a) - 1
    while l < r:
        mid = (l + r) >> 1
        if a[mid] < t:
            l = mid + 1
        else:
            r = mid 
    return -1 if a[l] < t else l

    
class Solution:
    def __init__(self):
        self.root = self.Node()

    def sumPrefixScores(self, words):
        n = len(words)
        ans = [0] * n
        for w in words:
            self.insert(w)
        for i in range(n):
            cur = self.root
            for c in words[i]:
                cur = cur.son[ord(c) - ord('a')]
                ans[i] += cur.score
        return ans

    def insert(self, s):
        cur = self.root
        for c in s:
            j = ord(c) - ord('a')
            if cur.son[j] is None:
                cur.son[j] = self.Node()
            cur.score += 1
            cur = cur.son[j]
        cur.isEnd = True
        cur.score += 1

    class Node:
        def __init__(self):
            self.son = [None] * 26
            self.isEnd = False
            self.score = 0
