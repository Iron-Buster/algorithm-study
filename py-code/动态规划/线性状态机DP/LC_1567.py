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


# 1567. 乘积为正数的最长子数组长度
# 第 204 场周赛
# Q2
# 1710
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。

# 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。

# 请你返回乘积为正数的最长子数组长度。

 

# 示例  1：

# 输入：nums = [1,-2,-3,4]
# 输出：4
# 解释：数组本身乘积就是正数，值为 24 。
# 示例 2：

# 输入：nums = [0,1,-2,-3,-4]
# 输出：3
# 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
# 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。
# 示例 3：

# 输入：nums = [-1,-2,-3,0,1]
# 输出：2
# 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。

class Solution:
    '''
        dp[i][0] 表示乘积为正数的最大子数组长度
        dp[i][1] 表示乘积为负数的最大子数组长度
    '''
    def getMaxLen(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [[0 for _ in range(2)] for _ in range(n)]
        if nums[0] > 0:
            dp[0][0] = 1
        elif nums[0] < 0: 
            dp[0][1] = 1
        ans = dp[0][0]
        for i in range(1, n):
            if nums[i] > 0:                 # 当前是正数
                dp[i][0] = dp[i - 1][0] + 1
                if dp[i - 1][1] != 0:
                    dp[i][1] = dp[i - 1][1] + 1    
            elif nums[i] < 0:               # 当前是负数
                dp[i][1] = dp[i - 1][0] + 1
                if dp[i - 1][1] != 0:
                    dp[i][0] = dp[i - 1][1] + 1
            else:
                dp[i][0] = dp[i][1] = 0
            ans = max(ans, dp[i][0])
        return ans
        