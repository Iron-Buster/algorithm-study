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




# 1255. 得分最高的单词集合
# 已解答
# 第 162 场周赛
# Q4
# 1882
# 相关标签
# 相关企业
# 提示
# 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。

# 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。

# 单词拼写游戏的规则概述如下：

# 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
# 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
# 单词表 words 中每个单词只能计分（使用）一次。
# 根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
# 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。

class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        cnt = [0] * 26
        for _, x in enumerate(letters):
            cnt[ord(x) - 97] += 1
        ans = 0
        def dfs(i: int, v: int) -> None:
            nonlocal ans
            if i >= len(words):
                ans = max(ans, v)
                return
            # 不选第i个word
            dfs(i + 1, v)
            # 选第i个word
            ok = True
            for _, c in enumerate(words[i]):
                if cnt[ord(c) - 97] == 0:
                    ok = False
                v += score[ord(c) - 97]
                cnt[ord(c) - 97] -= 1
            if ok:                  # 如果为False表示剩余单词数不足，无法选第i个word
                dfs(i + 1, v)
            # 恢复现场
            for _, c in enumerate(words[i]):
                cnt[ord(c) - 97] += 1
        dfs(0, 0)
        return ans


