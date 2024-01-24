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


# 100103. 分类求和并作差
# 简单
# 相关企业
# 提示
# 给你两个正整数 n 和 m 。

# 现定义两个整数 num1 和 num2 ，如下所示：

# num1：范围 [1, n] 内所有 无法被 m 整除 的整数之和。
# num2：范围 [1, n] 内所有 能够被 m 整除 的整数之和。
# 返回整数 num1 - num2 。

class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        v1 = 0
        v2 = 0
        for i in range(1, n + 1):
            if i % m == 0: v2 += i
            else: v1 += i
        return v1 - v2