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




# 17. 电话号码的字母组合
# 中等
# 相关标签
# 相关企业
# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
# 输入：digits = "23"
# 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

A = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        ans = []
        s = ''
        def dfs(idx: int) -> None:
            nonlocal s
            if idx >= len(digits):
                ans.append(s)
                return
            for c in A[int(digits[idx])]:
                s += str(c)
                dfs(idx+1)
                s = s[:-1]
            return
        dfs(0)
        return ans
    


def solve():
    s = Solution().letterCombinations('23')
    print(s)
    # ss = "aaa"
    # print(ss[:-1])


solve()