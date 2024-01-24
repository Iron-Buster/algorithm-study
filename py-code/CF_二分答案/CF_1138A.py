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


'''
    给定一个只包含 1, 2的数组
    求出 类似 [2,2,1,1] or [1,1,2,2] 的最长连续字段
    即每个类型相等, 且子段的每一半都只有一种类型

    input:
    7
    2 2 2 1 1 2 2
    output: 
    4
'''

def solve():
    n = II()
    t = LII()
    l, r = 0, n + 1
    def check(m: int) -> bool:
        # last记录上一段区间数字数量, cnt记录当前段数字数量
        cnt = last = 0
        for i in range(1, n):
            if t[i] == t[i - 1]:
                cnt += 1
                if last >= m and cnt == m: # 上一段和这一段都满足
                    return True
            else:
                last = cnt
                cnt = 1
        return False
    while l < r:
        mid = l + r + 1 >> 1
        if check(mid): 
            l = mid
        else:
            r = mid - 1
    print(l)


def main():
    solve()
main()

