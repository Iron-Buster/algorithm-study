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

# 405. 最长快乐字符串
# 已解答
# 第 183 场周赛
# Q3
# 1821
# 相关标签
# 相关企业
# 提示
# 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。

# 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：

# s 是一个尽可能长的快乐字符串。
# s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
# s 中只含有 'a'、'b' 、'c' 三种字母。
# 如果不存在这样的字符串 s ，请返回一个空字符串 ""。


class Solution:
    '''
        优先队列 + 贪心思路
        优先处理abc 数量最多的一个
        用两个变量cnt, pre 分别记录上一个字符连续出现的次数cnt 和上一个选择的字符pre
        当cnt == 2 并且 pre == cur.ch时 需要弹出next字符进行拼接
    '''
    def longestDiverseString(self, a: int, b: int, c: int) -> str:
        pq = []
        if a: pq.append((-a, 'a'))
        if b: pq.append((-b, 'b'))
        if c: pq.append((-c, 'c'))
        heapify(pq)
        ans = []
        cnt = 0
        pre_char = ''
        while len(pq):
            val, char = heappop(pq)
            if cnt == 2 and pre_char == char:
                if len(pq) < 1: break
                next_val, next_char = heappop(pq)
                ans.append(next_char)
                pre_char = next_char
                next_val += 1
                if -next_val > 0: heappush(pq, (next_val, next_char))
                cnt = 1
            else:
                ans.append(char)
                if pre_char != char: cnt = 1
                else: cnt += 1
                pre_char = char
                val += 1
            if -val > 0: heappush(pq, (val, char))
        return "".join(ans)