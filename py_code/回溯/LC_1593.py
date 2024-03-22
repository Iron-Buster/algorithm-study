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


# 1593. 拆分字符串使唯一子字符串的数目最大
# 已解答
# 第 207 场周赛
# Q2
# 1740
# 相关标签
# 相关企业
# 提示
# 给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。

# 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。

# 注意：子字符串 是字符串中的一个连续字符序列。

 

# 示例 1：

# 输入：s = "ababccc"
# 输出：5
# 解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
# 示例 2：

# 输入：s = "aba"
# 输出：2
# 解释：一种最大拆分方法为 ['a', 'ba'] 。
# 示例 3：

# 输入：s = "aa"
# 输出：1
# 解释：无法进一步拆分字符串。

# 1 <= s.length <= 16 数据范围较小 直接回溯

class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        ans = 0
        st = set()
        def dfs(pre: int, i: int) -> None:
            nonlocal ans
            if i >= len(s):
                ans = max(ans, len(st))
                return
            # 以i结尾划分
            sub = s[pre:i]
            if sub not in st:
                st.add(sub)
                dfs(i + 1, i + 1)
                st.remove(sub)
            # 继续追加s[i]
            dfs(pre, i + 1)
        
        dfs(0, 0)
        return ans