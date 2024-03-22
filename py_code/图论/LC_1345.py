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


# 1345. 跳跃游戏 IV
# 第 19 场双周赛
# Q4
# 1810
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。

# 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：

# i + 1 需满足：i + 1 < arr.length
# i - 1 需满足：i - 1 >= 0
# j 需满足：arr[i] == arr[j] 且 i != j
# 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。

# 注意：任何时候你都不能跳到数组外面


# 示例 1：

# 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
# 输出：3
# 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。

class Solution:
    '''
        BFS找最短路 枚举三种操作
    '''
    def minJumps(self, arr: List[int]) -> int:
        n = len(arr)
        pos = defaultdict(list)
        for i, x in enumerate(arr):
            pos[x].append(i)
        vis = [0] * n
        vis[0] = 1
        q = deque([(0, 0)])
        while q:
            i, step = q.popleft()
            if i == n - 1:
                return step
            for next in pos[arr[i]] + [i - 1, i + 1]:
                if next < 0 or next >= n or vis[next]:
                    continue
                vis[next] = 1
                q.append((next, step + 1))
            # 删除这个arr[i] 确保等值下标只会遍历依一次
            pos[arr[i]] = []
        return -1