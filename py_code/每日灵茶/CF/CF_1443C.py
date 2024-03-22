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


# https://codeforces.com/problemset/problem/1443/C

# 输入 T(≤2e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
# 每组数据输入 n(1≤n≤2e5) 和两个长为 n 的数组 a b，元素范围在 [1,1e9]。

# 把下标 0,1,2,...,n-1 分成两组，记作 P 和 Q。
# 对于 P 中的下标 i，计算 a[i] 的最大值 m。
# 对于 Q 中的下标 j，计算 b[j] 的和 s。
# 输出 max(m, s) 的最小值。

# 例如 a=[3,7,4,5], b=[2,1,2,4]，如果 P=[0,3], Q=[1,2]，那么 m=5, s=3，所以 max(m,s)=5。

# 输入
# 4
# 4
# 3 7 4 5
# 2 1 2 4
# 4
# 1 2 3 4
# 3 3 3 3
# 2
# 1 2
# 10 10
# 2
# 10 10
# 1 2
# 输出
# 5
# 3
# 2
# 3


# 把 a 和 b 绑在一起，按照 a[i] 从小到大排序。
# 枚举 m=a[i]，所有下标 <=i 的 b[i] 就不用选了，所以 s 等于 b[i+1] 之后的所有元素之和。

# https://codeforces.com/contest/1443/submission/228750000

def solve():
    n = II()
    a = LII()
    b = LII()
    s = sum(b)
    ve = []
    for i in range(n):
        ve.append([a[i], b[i]])
    ve.sort(key=lambda x: x[0])
    ans = s
    for i in range(n):
        m = ve[i][0]
        s -= ve[i][1]
        ans = min(ans, max(m, s))
    print(ans)


def main():
    t = II()
    for _ in range(t):
        solve()
main()

