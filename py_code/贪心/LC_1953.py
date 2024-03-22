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


# 1953. 你可以工作的最大周数
# 已解答
# 第 252 场周赛
# Q2
# 1804
# 相关标签
# 相关企业
# 提示
# 给你 n 个项目，编号从 0 到 n - 1 。同时给你一个整数数组 milestones ，其中每个 milestones[i] 表示第 i 个项目中的阶段任务数量。

# 你可以按下面两个规则参与项目中的工作：

# 每周，你将会完成 某一个 项目中的 恰好一个 阶段任务。你每周都 必须 工作。
# 在 连续的 两周中，你 不能 参与并完成同一个项目中的两个阶段任务。
# 一旦所有项目中的全部阶段任务都完成，或者仅剩余一个阶段任务都会导致你违反上面的规则，那么你将 停止工作 。注意，由于这些条件的限制，你可能无法完成所有阶段任务。

# 返回在不违反上面规则的情况下你 最多 能工作多少周。


class Solution:
    '''
        贪心(插空法)
    '''
    def numberOfWeeks(self, a: List[int]) -> int:
        s = sum(a)
        mx = max(a)
        # 1.如果最大的任务数量 小于 其他任务数量的总和 那么这个最大的任务一定能全部完成
        # 2.剩下一个任务无法完成 那么这个任务数量最多的 它最后对答案贡献是1
        if mx > s - mx:
            return 2 * (s - mx) + 1
        return s