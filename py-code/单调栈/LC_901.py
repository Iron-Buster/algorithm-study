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


# 901. 股票价格跨度
# 已解答
# 第 101 场周赛
# Q2
# 1709
# 相关标签
# 相关企业
# 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。

# 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

# 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。

# 实现 StockSpanner 类：

# StockSpanner() 初始化类对象。
# int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。

'''
    单调栈
    
'''
class StockSpanner:

    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        v = 1 # 初始跨度为1
        # 单调栈依次弹出比当前price小的连续元素 并且累加他们的跨度
        while self.stack and self.stack[-1][0] <= price:
            v += self.stack.pop()[1]  # 累加连续的跨度
        self.stack.append((price, v))
        return v


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)