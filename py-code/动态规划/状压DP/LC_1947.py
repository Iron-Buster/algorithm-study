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


# 1947. 最大兼容性评分和
# 第 251 场周赛
# Q3
# 1704
# 相关标签
# 相关企业
# 提示
# 有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。

# 这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。学生的答案用一个二维整数数组 students 表示，其中 students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。导师的答案用一个二维整数数组 mentors 表示，其中 mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。

# 每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。

# 例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。
# 请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。

# 给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。

 

# 示例 1：

# 输入：students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
# 输出：8
# 解释：按下述方式分配学生和导师：
# - 学生 0 分配给导师 2 ，兼容性评分为 3 。
# - 学生 1 分配给导师 0 ，兼容性评分为 2 。
# - 学生 2 分配给导师 1 ，兼容性评分为 3 。
# 最大兼容性评分和为 3 + 2 + 3 = 8 


class Solution:
    '''
        dfs枚举
    '''
    def maxCompatibilitySum(self, students: List[List[int]], mentors: List[List[int]]) -> int:
        ans = -inf
        vis = [0] * 10
        def dfs(i: int, score: int) -> None:
            nonlocal ans
            if i >= len(students):
                ans = max(ans, score)
                return
            for j, m in enumerate(mentors):
                if vis[j]: continue
                s = 0
                vis[j] = 1
                for k, v in enumerate(m):
                    if students[i][k] == v:
                        s += 1
                dfs(i + 1, score + s)
                vis[j] = 0
        dfs(0, 0)
        return ans

    '''
        状压dp
    '''
    def maxCompatibilitySum2(self, students: List[List[int]], mentors: List[List[int]]) -> int:
        m = len(students)
        mask = 1 << m
        cnt = [[0 for _ in range(m + 1)] for _ in range(m + 1)]
        dp = [[0 for _ in range(m + 1)] for _ in range(m + 1)]
        def calc(a: List[int], b: List[int]) -> int:
            return sum(a[i] == a[i] for i in range(len(a)))
        for i in range(m):
            for j in range(m):
                cnt[i + 1][j + 1] = calc(students[i], mentors[j])
        print(cnt)
        for i in range(1, m + 1):
            for j in range(1, mask):
                for k in range(m):
                    if (j & (1 << k)) != 0:
                        dp[i][j] = max(dp[i][j], dp[i - 1][j ^ (1 << k)] + cnt[i][k + 1])
        return dp[m][mask - 1]
    
