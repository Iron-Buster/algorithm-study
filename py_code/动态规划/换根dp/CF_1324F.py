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
from typing import *

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

'''
https://codeforces.com/problemset/problem/1324/F
'''

def solve():
    n = II()
    a = LII()
    a = [1 if a[i] == 1 else -1 for i in range(n)]
    g = defaultdict(list)
    for _ in range(n - 1):
        u, v = LII()
        u -= 1
        v -= 1
        g[u].append(v)
        g[v].append(u)

    dp = [0] * n

    def dfs(x: int, fa: int) -> None:
        dp[x] = a[x]
        for y in g[x]:
            if y == fa:
                continue
            dfs(y, x)
            if dp[y] > 0:
                dp[x] += dp[y]

    # f[x] -> f[y]
    # 1.f[y]给f[x]贡献了, f[y] = max(f[y], f[x])
    # 2.f[y]没给f[x]贡献, f[y] = max(f[y], f[y] + f[x])
    def dfs2(x: int, fa: int) -> None:
        for y in g[x]:
            if y == fa:
                continue
            if dp[y] > 0:
                dp[y] = max(dp[y], dp[x])
            else:
                dp[y] = max(dp[y], dp[y] + dp[x])
            dfs2(y, x)


    dfs(0, -1)
    dfs2(0, -1)
    print(*dp)

def main():
    t = 1
    for _ in range(t):
        solve()


main()
