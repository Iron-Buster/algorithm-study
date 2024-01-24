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


# 全伯兰团队编程竞赛即将举行。今年允许四人组队参加。

# 伯兰州立大学有 a 名程序员和 b 名数学家。如果：

# - 每支参赛队必须正好由 4 名学生组成、
# - 由4名数学家或4名程序员组成的小组不可能取得好成绩，因此决定不组成这样的小组。

# 因此，每个小组必须至少有一名程序员和一名数学家。

# 打印所需的最多团队人数。每个人只能参加一个小组。

def check(m: int, a: int, b: int) -> bool:
    if a < m or b < m: return False         
    if (a + b) < m * 4: return False
    return True

def solve():
    a, b = MI()
    if a == 0 or b == 0:
        print(0)
        return
    l, r = 0, (a + b) // 4
    while l < r:
        mid = l + r + 1 >> 1
        if check(mid, a, b):
            l = mid
        else:
            r = mid - 1
    print(l)


def main():
    t = II()
    for _ in range(t):
        solve()
main()

