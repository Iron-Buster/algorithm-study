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


# write code here
def solve():
    # A
    # n = II()
    # a = LII()
    # ans = sum(abs(x) for x in a)
    # print(ans)

    # C
    # lii = LII()
    # a = lii[0]
    # b = lii[1]
    # l = lii[2]
    # # 2 3 72
    # st = set()
    # if l % a != 0 and l % b != 0:
    #     print(1)
    #     return
    # r1 = 100
    # r2 = 100
    # for x in range(r1):
    #     for y in range(r2):
    #         if l < ((a ** x) * (b ** y)):
    #             break
    #         k = l // ((a ** x) * (b ** y))
    #         if 0 < k <= l:
    #             if l % k == 0:
    #                 if ((a ** x) * (b ** y)) * k == l:
    #                     st.add(k)
    # print(len(st))

    # B
    # n = II()
    # a = LII()
    # s = sum(a)
    # if s % 3 == 0:
    #     print(0)
    #     return
    # for x in a:
    #     if (s-x) % 3 == 0:
    #         print(1)
    #         return
    # if (s+1) % 3 == 0:
    #     print(1)
    #     return
    # if (s+2) % 3 == 0:
    #     print(2)
    #     return

    #D
    n = II()
    a = LII()

    a.sort()
    if a[0] != a[1]:
        print('YES')
        return
    for i in range(1, n):
        if a[i] % a[0] != 0:
            print('YES')
            return
    print('NO')

def main():
    t = II()  # more than onc case
    for _ in range(t):
        solve()


main()
