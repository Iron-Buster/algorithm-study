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
def SUF(a):
    n = len(a)
    suf = [0] * (n + 1)
    for i in range(n - 1, -1, -1):
        suf[i] = suf[i + 1] + a[i]
    return suf
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



# 1298. 你能从盒子里获得的最大糖果数
# 第 168 场周赛
# Q4
# 1825
# 相关标签
# 相关企业
# 提示
# 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：

# 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
# 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
# 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
# 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
# 给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。

# 请你按照上述规则，返回可以获得糖果的 最大数目 。


class Solution:
    def maxCandies(self, status: List[int], candies: List[int], keys: List[List[int]], containedBoxes: List[List[int]], initialBoxes: List[int]) -> int:
        ans = 0
        q = deque()
        boxs = []
        vis = [0] * len(status)
        for x in initialBoxes:
            boxs.append(x)
            if status[x]:
                q.append(x)
                ans += candies[x]
                vis[x] = 1
        while q:
            p = q.popleft()
            for x in keys[p]:
                status[x] = 1
            for nx in containedBoxes[p]:
                boxs.append(nx)
            for nx in boxs:
                if not status[nx] or vis[nx]:
                    continue
                ans += candies[nx]
                q.append(nx)
                vis[nx] = 1
        return ans
            
        

        

