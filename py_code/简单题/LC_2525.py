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

# 2525. 根据规则将箱子分类
# 已解答
# 第 95 场双周赛
# Q1
# 1301
# 相关标签
# 相关企业
# 提示
# 给你四个整数 length ，width ，height 和 mass ，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。

# 如果满足以下条件，那么箱子是 "Bulky" 的：
# 箱子 至少有一个 维度大于等于 104 。
# 或者箱子的 体积 大于等于 109 。
# 如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
# 如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
# 如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
# 如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
# 如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
# 注意，箱子的体积等于箱子的长度、宽度和高度的乘积。

class Solution:
    def categorizeBox(self, length: int, width: int, height: int, mass: int) -> str:
        f1 = f2 = False
        v = length * width * height
        if length >= 10**4 or width >= 10**4 or height >= 10**4 or mass >= 10**4 or v >= 10**9:
            f1 = True
        if mass >= 100:
            f2 = True
        if f1 and f2:
            return "Both"
        if not f1 and not f2:
            return "Neither"
        if f1:
            return "Bulky"
        return "Heavy"
