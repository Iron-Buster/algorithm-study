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

# https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m = len(matrix)
        n = len(matrix[0])
        # O(n + m) 统计 <= m的个数
        def check(mid: int) -> bool:
            i = 0
            j = n - 1
            cnt = 0
            while i < m and j >= 0:
                if matrix[i][j] <= mid:
                    cnt += j + 1
                    i += 1
                else:
                    j -= 1
            return cnt >= k

        l = matrix[0][0]
        r = matrix[m-1][n-1]
        while l < r:
            mid = l + r >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l