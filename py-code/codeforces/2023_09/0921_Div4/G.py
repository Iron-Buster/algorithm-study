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
    分类讨论
    1.AAAAAB 或 BAAAA 中的A都能换成coin
        AB => AAAABC => AAABC ... => BC
        BA => CBAAA => CBAA ... => CB 
    2.AAAABAAA => 这种情况只有 一边能变成coin 
    3.AAABBAAAA => 都能变成coin
    需要用B抵消更多A  所以找长度最短的A 答案是A的总数减去这个长度
'''

def solve():
    t = II()
    for _ in range(t):
        s = I()
        n = len(s)
        tot = s.count('A')
        if tot == n: 
            print(0)
            continue
        # 特判断是否是第2中情况 (B在中间出现)
        if s[0] == 'A' and s[n - 1] == 'A': 
            ok = True
            for i in range(n - 1):
                if s[i] == 'B' and s[i + 1] == 'B': # 第3种情况
                    ok = False
            if ok:                                  # 处理第2种情况
                mn = inf
                lst = -1
                for i in range(n):
                    if s[i] == 'A': continue
                    mn = min(mn, i - lst - 1)       # 找到更短的连续A
                    lst = i
                mn = min(mn, n - lst - 1)
                tot -= mn
        print(tot)   

solve()


