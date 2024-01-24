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


# 2842. 统计一个字符串的 k 子序列美丽值最大的数目
# 提示
# 困难
# 1
# 相关企业
# 给你一个字符串 s 和一个整数 k 。
#
# k 子序列指的是 s 的一个长度为 k 的 子序列 ，且所有字符都是 唯一 的，也就是说每个字符在子序列里只出现过一次。
#
# 定义 f(c) 为字符 c 在 s 中出现的次数。
#
# k 子序列的 美丽值 定义为这个子序列中每一个字符 c 的 f(c) 之 和 。
#
# 比方说，s = "abbbdd" 和 k = 2 ，我们有：
#
# f('a') = 1, f('b') = 3, f('d') = 2
# s 的部分 k 子序列为：
# "abbbdd" -> "ab" ，美丽值为 f('a') + f('b') = 4
# "abbbdd" -> "ad" ，美丽值为 f('a') + f('d') = 3
# "abbbdd" -> "bd" ，美丽值为 f('b') + f('d') = 5
# 请你返回一个整数，表示所有 k 子序列 里面 美丽值 是 最大值 的子序列数目。由于答案可能很大，将结果对 109 + 7 取余后返回。
#
# 一个字符串的子序列指的是从原字符串里面删除一些字符（也可能一个字符也不删除），不改变剩下字符顺序连接得到的新字符串。
from collections import Counter

from math import comb


class Solution:
    def countKSubsequencesWithMaxBeauty(self, s: str, k: int) -> int:
        MOD = 10 ** 9 + 7
        ans = 1
        cnt = Counter(Counter(s).values())
        for c, num in sorted(cnt.items(), reverse=True):
            if num >= k:
                return ans * pow(c, k, MOD) * comb(num, k) % MOD
            ans *= pow(c, num, MOD)
            k -= num
        return 0

if __name__ == '__main__':
    res = comb(6, 2)
    print(res)


