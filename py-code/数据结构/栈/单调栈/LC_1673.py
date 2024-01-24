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


# 1673. 找出最具竞争力的子序列
# 已解答
# 第 217 场周赛
# Q2
# 1802
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。

# 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。

# 在子序列 a 和子序列 b 第一个不相同的位置上，
# 如果 a 中的数字小于 b 中对应的数字，
# 那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 
# 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。


class Solution:
    '''
        单调栈 + 贪心
    '''
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        stack = []
        right = [0] * n     # right[i]存储i右边第一个小的元素
        for i in range(n - 1, -1, -1):
            while stack and nums[stack[-1]] >= nums[i]:
                stack.pop()
            right[i] = stack[-1] if stack else -1
            stack.append(i)
        ans = []
        for i in range(n):
            if k == 0: break
            # 如果后面有比nums[i]小的数 并且后面也可以选出一个长度为k的子序列
            # 那么当前的nums[i]可以不选 贪心选最具竞争力的子序列
            if right[i] != -1 and n - right[i] >= k:
                continue
            ans.append(nums[i])
            k -= 1
        return ans
