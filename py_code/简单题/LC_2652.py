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


# 2652. 倍数求和
# 已解答
# 第 342 场周赛
# Q2
# 1182
# 相关标签
# 相关企业
# 提示
# 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。

# 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。


class Solution:
    def sumOfMultiples(self, n: int) -> int:
        return sum(i for i in range(1, n + 1) if i % 3 == 0 or i % 5 == 0 or i % 7 == 0)