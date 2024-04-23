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


# https://leetcode.cn/problems/maximum-segment-sum-after-removals/description

'''
    逆序并查集
    先将所有点删除，再倒序连接，维护最大和
'''


class Solution:
    def maximumSegmentSum(self, nums: List[int], removeQueries: List[int]) -> List[int]:
        n = len(nums)
        fa = [0] * n
        rank = [0] * n
        for i in range(n):
            fa[i] = i
            rank[i] = nums[i]

        def find(x: int) -> int:
            while x != fa[x]:
                fa[x] = fa[fa[x]]
                x = fa[x]
            return x

        def merge(x: int, y: int) -> None:
            rx = find(x)
            ry = find(y)
            if rx == ry: return
            fa[ry] = rx
            rank[rx] += rank[ry]

        ans = [0] * n
        vis = [False] * n
        m = len(removeQueries)
        mx = 0
        for i in range(m - 1, -1, -1):
            ans[i] = mx
            q = removeQueries[i]
            vis[q] = True
            if q - 1 >= 0 and vis[q - 1]:
                merge(q, q - 1)
            if q + 1 < n and vis[q + 1]:
                merge(q, q + 1)
            mx = max(mx, rank[find(q)])
        return ans