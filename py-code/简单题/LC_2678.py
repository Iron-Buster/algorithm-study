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
    


# 2678. 老人的数目
# 已解答
# 第 104 场双周赛
# Q1
# 1199
# 相关标签
# 相关企业
# 提示
# 给你一个下标从 0 开始的字符串 details 。details 中每个元素都是一位乘客的信息，信息用长度为 15 的字符串表示，表示方式如下：

# 前十个字符是乘客的手机号码。
# 接下来的一个字符是乘客的性别。
# 接下来两个字符是乘客的年龄。
# 最后两个字符是乘客的座位号。
# 请你返回乘客中年龄 严格大于 60 岁 的人数。

class Solution:
    def countSeniors(self, details: List[str]) -> int:
        return sum(1 for s in details if int(s[11:13]) > 60)