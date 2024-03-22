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


# 513. 仅含 1 的子串数
# 已解答
# 第 197 场周赛
# Q2
# 1351
# 相关标签
# 相关企业
# 提示
# 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。

# 返回所有字符都为 1 的子字符串的数目。

# 由于答案可能很大，请你将它对 10^9 + 7 取模后返回



class Solution:
    def numSub(self, s: str) -> int:
        j = 0
        ans = 0
        for i, x in enumerate(s):
            if x == '0':
                j = i + 1
                continue
            ans += i - j + 1
            ans %= 1000000007
        return ans