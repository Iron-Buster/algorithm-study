'''
    https://atcoder.jp/contests/abc248/tasks/abc248_d

    输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)，下标从 1 开始。
    然后输入 q 个询问，每个询问输入 L R (1≤L≤R≤n) 和 x(1≤x≤n)。
    对每个询问，输出有多少个下标 i 在 [L,R] 内的 a[i]，满足 a[i]=x。

    输入
    5
    3 1 4 1 5
    4
    1 5 1
    2 4 3
    1 5 2
    1 3 3
    输出
    2
    0
    0
    1

    【灵茶の试炼】往期题目&题解汇总
    https://docs.qq.com/sheet/DWGFoRGVZRmxNaXFz

'''

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

    #     D - Range Count Query
    # https://atcoder.jp/contests/abc248/tasks/abc248_d

    # 输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)，下标从 1 开始。
    # 然后输入 q 个询问，每个询问输入 L R (1≤L≤R≤n) 和 x(1≤x≤n)。
    # 对每个询问，输出有多少个下标 i 在 [L,R] 内的 a[i]，满足 a[i]=x。

    # 输入
    #     5
    #     3 1 4 1 5
    #     4
    #     1 5 1
    #     2 4 3
    #     1 5 2
    #     1 3 3
    # 输出
    #     2
    #     0
    #     0
    #     1

    #     【灵茶の试炼】往期题目&题解汇总
    # https://docs.qq.com/sheet/DWGFoRGVZRmxNaXFz

def solve():
    n = II()
    a = LII()
    pos = defaultdict(list)
    for i, v in enumerate(a):
        pos[v].append(i + 1)
    q = II()
    for _ in range(q):
        l, r, x = MI()
        s = pos[x]
        L = bisect_left(s, l)
        R = bisect_right(s, r)
        print(R - L)

solve()