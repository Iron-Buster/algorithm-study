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


# 2055. 蜡烛之间的盘子
# 已解答
# 第 64 场双周赛
# Q3
# 1819
# 相关标签
# 相关企业
# 提示
# 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。

# 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。

# 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
# 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。



class Solution:
    '''
        前缀和 + 二分
    '''
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        pre = [0] * (n + 1)
        ls = []
        for i in range(n):
            pre[i + 1] = pre[i]
            if s[i] == '|':
                ls.append(i)
            else:
                pre[i + 1] += 1
        ans = [0] * len(queries)
        if len(ls) == 0: return ans
        for i, (L, R) in enumerate(queries):
            if L == R: continue
            # 二分找最近的蜡烛 L往右找 R往左找
            idx1 = self.rightBound(ls, L)
            idx2 = self.leftBound(ls, R)
            if idx1 != -1 and idx2 != -1 and idx1 < idx2:
                ans[i] = pre[idx2 + 1] - pre[idx1]
        return ans

    # 二分找右边界
    def rightBound(self, a: List[int], t: int) -> int:
        l, r = 0, len(a) - 1
        while l < r:
            mid = (l + r) >> 1
            if a[mid] < t:
                l = mid + 1
            else:
                r = mid 
        return a[l] if a[l] >= t else -1
    
    # 二分找左边界
    def leftBound(self, a: List[int], t: int) -> int:
        l, r = 0, len(a) - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if a[mid] > t:
                r = mid - 1
            else:
                l = mid
        return a[l] if a[l] <= t else -1

               
