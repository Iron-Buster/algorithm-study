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


# 118. 杨辉三角
# 已解答
# 简单
# 相关标签
# 相关企业
# 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

# 在「杨辉三角」中，每个数是它左上方和右上方的数的和。

class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = []
        for i in range(numRows):
            ls = []
            for j in range(i + 1):
                if j == 0 or j == i:
                    ls.append(1)
                else:
                    print(ans[i - 1])
                    print(j)
                    v = ans[i - 1][j - 1] + ans[i - 1][j]
                    ls.append(v)
            ans.append(ls)
            print(ans)
        return ans