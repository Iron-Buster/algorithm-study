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


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
# input = lambda: sys.stdin.readline().rstrip("\r\n")
input = lambda: sys.stdin.readline().rstrip()


def I():
    return input()


def II():
    return int(input())


def MI():
    return map(int, input().split())


def LI():
    return list(input().split())


def LII():
    return list(map(int, input().split()))


def GMI():
    return map(lambda x: int(x) - 1, input().split())


def LGMI():
    return list(map(lambda x: int(x) - 1, input().split()))


def PF(a):
    return [0] + list(accumulate(a))

# https://atcoder.jp/contests/abc208/tasks/abc208_e

# 输入 n(1≤n≤1e18) 和 k(1≤k≤1e9)。
# 问：有多少个不超过 n 的正整数，其数位乘积不超过 k？ -> 数位DP

'''
    case1: 前导零的情况会影响答案 -> 0 * 4 = 0 其实 4 > k(k=2) 
    case2: 数位DP -> 灵神模板
'''
def solve():
    n, k = MI()
    s = str(n)

    @cache
    def dfs(i: int, isLimit: bool, isNum: bool, mul: int) -> int:
        if i == len(s):
            return 1 if isNum and mul <= k else 0
        ans = 0
        if not isNum:
            ans += dfs(i + 1, False, False, mul)   # 第i位不填数字
        low = 0 if isNum else 1                    # 前导零的情况
        up = int(s[i]) if isLimit else 9           
        for d in range(low, up + 1):              
            ans += dfs(i + 1, isLimit and d == up, True, mul * d)
        return ans
    res = dfs(0, True, False, 1)
    print(res)


def main():
    solve()
main()

