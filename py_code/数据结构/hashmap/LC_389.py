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

# 389. 找不同
# 已解答
# 简单
# 相关标签
# 相关企业
# 给定两个字符串 s 和 t ，它们只包含小写字母。

# 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

# 请找出在 t 中被添加的字母。

class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        cnt = Counter(s)
        for x in t:
            if cnt[x] == 0:
                return x
            cnt[x] -= 1
            if cnt[x] == 0:
                del cnt[x]
            
        return ""