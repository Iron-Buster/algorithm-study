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


'''
2861. 最大合金数
https://leetcode.cn/problems/maximum-number-of-alloys/?envType=daily-question&envId=2024-01-27

输入：n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,0], cost = [1,2,3]
输出：2
解释：最优的方法是使用第 1 台机器来制造合金。
要想制造 2 份合金，我们需要购买：
- 2 份第 1 类金属。
- 2 份第 2 类金属。
- 2 份第 3 类金属。
总共需要 2 * 1 + 2 * 2 + 2 * 3 = 12 的金钱，小于等于预算 15 。
注意，我们最开始时候没有任何一类金属，所以必须买齐所有需要的金属。
可以证明在示例条件下最多可以制造 2 份合金。
'''


class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int, composition: List[List[int]], stock: List[int],
                          cost: List[int]) -> int:
        ans = 0
        def check(m: int) -> bool:
            s = 0
            for i, cnt in enumerate(stock):
                tot = m * cc[i] - cnt  # 制作m个i合金需要 m * cc[i] - stock[i]个金属
                if tot <= 0: continue
                s += tot * cost[i]
            return s > budget

        for cc in composition:
            l = 0
            r = 10 ** 8
            while l < r:
                mid = l + r + 1 >> 1
                if check(mid):
                    r = mid - 1
                else:
                    l = mid
            ans = max(ans, l)
        return ans


if __name__ == '__main__':
    print(Solution().maxNumberOfAlloys(4, 4, 17, [[10, 10, 1, 5], [9, 7, 7, 1], [6, 3, 5, 9], [2, 10, 2, 7]],
                                       [9, 8, 2, 7], [9, 2, 6, 10]))
