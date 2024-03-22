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


# 100085. 最小处理时间
# 中等
# 相关企业
# 提示
# 你有 n 颗处理器，每颗处理器都有 4 个核心。现有 n * 4 个待执行任务，每个核心只执行 一个 任务。

# 给你一个下标从 0 开始的整数数组 processorTime ，表示每颗处理器最早空闲时间。
# 另给你一个下标从 0 开始的整数数组 tasks ，表示执行每个任务所需的时间。返回所有任务都执行完毕需要的 最小时间 。

# 注意：每个核心独立执行任务。

class Solution:
    '''
        尽量让空闲时间长的处理器去处理 耗时时间短的任务
    '''
    def minProcessingTime(self, processorTime: List[int], tasks: List[int]) -> int:
        tasks.sort()
        processorTime.sort(key=lambda x: -x)
        ans = -inf
        n = len(tasks)
        j = 0
        for i in range(n):
            if i and i % 4 == 0:
                j += 1
            ans = max(ans, processorTime[j] + tasks[i])
        return ans