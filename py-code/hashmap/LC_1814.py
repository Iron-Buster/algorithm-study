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


# 1814. 统计一个数组中好对子的数目
# 第 49 场双周赛
# Q3
# 1738
# 相关标签
# 相关企业
# 提示
# 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。
# 比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：

# 0 <= i < j < nums.length
# nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
'''
                转化一下等式
                -> x + rev(y) == y + rev(x) 
                -> x - rev(x) = y - rev(y) 
                -> 等式两边当作哈希key
'''

# 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。

 

# 示例 1：

# 输入：nums = [42,11,1,97]
# 输出：2
# 解释：两个坐标对为：
#  - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
#  - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。

class Solution:
    '''
        转化一下等式
        -> x + rev(y) == y + rev(x) 
        -> x - rev(x) == y - rev(y) 
         -> 等式两边当作哈希key
    '''
    def countNicePairs(self, nums: List[int]) -> int:
      
        def rev(num: int) -> int:
            v = 0
            while num:
                v = v * 10 + num % 10
                num = num // 10
            return v

        mp = Counter(x - rev(x) for x in nums)
        return sum(v * (v - 1) // 2 for v in mp.values()) % MOD
    
def solve():
    ans = Solution().countNicePairs([42, 11, 1, 97])
    print(ans)
solve()
