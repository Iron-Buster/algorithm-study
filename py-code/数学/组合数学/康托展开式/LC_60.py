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


# 60. 排列序列
# 困难
# 相关标签
# 相关企业
# 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。

# 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

# "123"
# "132"
# "213"
# "231"
# "312"
# "321"
# 给定 n 和 k，返回第 k 个排列。

# 0~10的阶乘，这里采用打表法，也可以单独写个函数用于求阶乘
fac = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800] 

class Solution:
    '''
        逆康拓展开模板
    '''
    def getPermutation(self, n: int, k: int) -> str:
        k -= 1                      # k是排名 需要-1得到康拓值
        v = list(range(1, n + 1))   # 存放可选的数字，保证有序
        ans = []                    # 所求排列组合
        for i in range(n, 0, -1):
            r = k % fac[i - 1]
            t = k // fac[i - 1]
            k = r
            ans.append(str(v[t]))
            del v[t]
        return ''.join(ans)

