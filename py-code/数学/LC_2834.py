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

# n = 2, t = 3
# 1 + 3

# n = 3, t = 3
# 1 + 3 + 4

# n = 4, t = 4
# 1 + 2 + 4 + 5 = 12

# n = 10, t = 10
# 1 + 2 + 3 + 4 + 5 + 10 + 11 + 12 + 13 + 14

# n = 16, t = 6
# 1 + 2 + 3 +
# 从t开始 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18


# n = 13, t = 50
# 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13

# 2834. 找出美丽数组的最小和
# 已解答
# 第 360 场周赛
# Q2
# 1409
# 相关标签
# 相关企业
# 提示
# 给你两个正整数：n 和 target 。
#
# 如果数组 nums 满足下述条件，则称其为 美丽数组 。
#
# nums.length == n.
# nums 由两两互不相同的正整数组成。
# 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
# 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 109 + 7。


class Solution:
    def minimumPossibleSum(self, n: int, target: int) -> int:
        v = target // 2
        if n < v:
            return ((1 + n) * n // 2) % MOD
        s0 = (1 + v) * v // 2
        s1 = (target + (target + (n-v-1))) * (n-v) // 2
        return (s0 + s1) % MOD


if __name__ == '__main__':
    # print(Solution().minimumPossibleSum(2, 3))
    # print(Solution().minimumPossibleSum(3, 3))
    # print(Solution().minimumPossibleSum(4, 4))
    print(Solution().minimumPossibleSum(13, 50))