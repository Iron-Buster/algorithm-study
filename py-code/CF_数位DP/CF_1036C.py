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

# 如果某个正整数的十进制表示中包含的非零数字不超过 3 位，我们就称它为经典整数。
# 例如，数字 4、200000、10203 是优质数，而数字 4231、102306、7277420000 不是。
# 给你一个线段 [L; R]。请数出x中L \le x \le R的整数x的个数。
# 每个测试案例都包含多个片段，您需要分别解决每个片段的问题。

'''
    求区间[L,R]中数位上非0的数字个数不超过3个的 数字个数
    数位DP -> 灵神模板

'''
def calc(s: str) -> int:
    @cache
    def dfs(i: int, isLimit: bool, cnt: int) -> int:
        if i == len(s):
            return cnt <= 3      
        ans = 0
        up = int(s[i]) if isLimit else 9
        for d in range(up + 1):
            if cnt > 3 and d != 0: continue
            ans += dfs(i + 1, isLimit and d == up, cnt + (d != 0))
        return ans
    return dfs(0, True, 0)

def solve():
    L, R = MI()
    ans = calc(str(R)) - calc(str(L - 1))
    print(ans)

def main():
    t = II()
    for _ in range(t):
        solve()
main()

