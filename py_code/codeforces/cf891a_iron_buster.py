from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
import sys
import os
from io import BytesIO, IOBase

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

# https://codeforces.com/problemset/problem/891/A
# 每次只能将相邻两个元素的其中一个替换为 gcd(a1, a2) 求数组全变1的最少操作次数

def solve():
    n = II()
    a = LII()
    # 如果数组中有1，则答案是n-cnt(1)
    if a.count(1):
        print(n - a.count(1))
        return
    # 构造一个最小的区间[L,R] 使gcd(L,R) = 1
    t = 0x3f3f3f
    for i in range(n):
        g = 0
        for j in range(i, n):
            g = gcd(g, a[j])
            if g == 1:
                t = min(t, j - i)
                break
    if t == 0x3f3f3f:
        print(-1)
    else:
        print(t + n - 1)

def main():
    t = 1
    for _ in range(t):
        solve()

main()