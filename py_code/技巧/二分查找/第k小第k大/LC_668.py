from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))

# https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/description/

class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        # 统计 <= mid 的个数
        def check(mid: int) -> bool:
            i = 1
            j = n
            cnt = 0
            while i <= m and j > 0:
                if i * j <= mid:  # 枚举每行最右边的那个数字
                    cnt += j
                    i += 1
                else:
                    j -= 1  # 需要减小j
            return cnt >= k

        l = 1
        r = m * n
        while l < r:
            mid = l + r >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l