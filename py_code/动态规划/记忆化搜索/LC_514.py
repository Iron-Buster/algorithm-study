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
514. 自由之路
https://leetcode.cn/problems/freedom-trail/description/?envType=daily-question&envId=2024-01-29
输入: ring = "godding", key = "gd"
输出: 4
解释:
 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 当然, 我们还需要1步进行拼写。
 因此最终的输出是 4。
'''

class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        m = len(ring)
        n = len(key)
        g = defaultdict(list)
        for i, x in enumerate(ring):
            g[x].append(i)
        @cache
        def f(i: int, j: int) -> int:
            if i >= n: return 0
            ans = 0x3f3f3f
            for idx in g[key[i]]:
                ans = min(ans, f(i + 1, idx) + min(abs(idx - j), m - abs(idx - j)))
            return ans
        return f(0, 0) + n

if __name__ == '__main__':
    print(Solution().findRotateSteps("godding", "gd"))
