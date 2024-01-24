import heapq
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

# 2530. 执行 K 次操作后的最大分数
# 第 327 场周赛
# Q2
# 1386
# 相关标签
# 相关企业
# 提示
# 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。

# 在一步 操作 中：

# 选出一个满足 0 <= i < nums.length 的下标 i ，
# 将你的 分数 增加 nums[i] ，并且
# 将 nums[i] 替换为 ceil(nums[i] / 3) 。
# 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。

# 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。

class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        pq = [-x for x in nums]
        heapify(pq)
        ans = 0
        while len(pq) and k:
            x = heappop(pq)
            ans -= x
            heappush(pq, ceil(x // 3))
            k -= 1
        return ans