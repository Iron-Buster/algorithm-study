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


# 1594. 矩阵的最大非负积
# 已解答
# 第 207 场周赛
# Q3
# 1807
# 相关标签
# 相关企业
# 提示
# 给你一个大小为 m x n 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。

# 在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。

# 返回 最大非负积 对 109 + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。

# 注意，取余是在得到最大积之后执行的



class Solution:
    '''
        dp[i][j][0] 表示以i,j结尾的正数的最大乘积
        dp[i][j][1] 表示以i,j结尾的负数的最大乘积
    '''
    def maxProductPath(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dp = [[[0, 0] for _ in range(n)] for _ in range(m)]
        dp[0][0][0] = dp[0][0][1] = grid[0][0]
        # dp数组初始化第一列,第一行
        for i in range(1, m):
            v = grid[i][0]
            dp[i][0][0] = max(dp[i - 1][0][0] * v, dp[i - 1][0][1] * v)
            dp[i][0][1] = min(dp[i - 1][0][0] * v, dp[i - 1][0][1] * v)
        for j in range(1, n):
            v = grid[0][j]
            dp[0][j][0] = max(dp[0][j - 1][0] * v, dp[0][j - 1][1] * v)
            dp[0][j][1] = min(dp[0][j - 1][0] * v, dp[0][j - 1][1] * v)
        for i in range(1, m):
            for j in range(1, n):
                v = grid[i][j]
                dp[i][j][0] = max(dp[i - 1][j][0] * v, dp[i - 1][j][1] * v, 
                                  dp[i][j - 1][0] * v, dp[i][j - 1][1] * v)
                dp[i][j][1] = min(dp[i - 1][j][0] * v, dp[i - 1][j][1] * v, 
                                  dp[i][j - 1][0] * v, dp[i][j - 1][1] * v)
        # 题目要求最大非负积
        ans = dp[m - 1][n - 1][0]
        return -1 if ans < 0 else ans % MOD


