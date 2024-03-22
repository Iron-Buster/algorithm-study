from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from random import *
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

# 3085. 成为 K 特殊字符串需要删除的最少字符数
# 中等
# 相关企业
# 提示
# 给你一个字符串 word 和一个整数 k。
#
# 如果 |freq(word[i]) - freq(word[j])| <= k 对于字符串中所有下标 i 和 j  都成立，则认为 word 是 k 特殊字符串。
#
# 此处，freq(x) 表示字符 x 在 word 中的
# 出现频率
# ，而 |y| 表示 y 的绝对值。
#
# 返回使 word 成为 k 特殊字符串 需要删除的字符的最小数量。


class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        cnt = [0] * 26
        for c in word:
            cnt[ord(c) - ord('a')] += 1
        cnt.sort()
        ans = inf
        for i in range(26):
            v = 0
            # i前面的全部删除
            for j in range(i):
                v += cnt[j]
            # i后面的删除cnt[j] - cnt[i] - k
            for j in range(i + 1, 26):
                if cnt[j] - cnt[i] > k:
                    v += cnt[j] - cnt[i] - k
            ans = min(ans, v)
        return ans
