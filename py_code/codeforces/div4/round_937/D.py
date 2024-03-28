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


a = [1, 10, 11, 100, 101, 110, 111,
     1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111,
     10000, 10001, 10010, 10011, 10100, 10101, 10110, 10111,
     11000, 11001, 11010, 11011, 11100, 11101, 11110, 11111]

def solve():
    x = II()
    a.sort()
    for val in a:
        if x == val:
            print('YES')
            return
    n = len(a)
    for i in range(n):
        for j in range(i, n):
            if a[i] * a[j] > x:
                break
            if a[i] * a[j] == x:
                print('YES')
                return
            for k in range(i, n):
                if a[i] * a[j] * a[k] > x:
                    break
                if a[i] * a[j] * a[k] == x:
                    print('YES')
                    return
                for l in range(i, n):
                    if a[i] * a[j] * a[k] * a[l] > x:
                        break
                    if a[i] * a[j] * a[k] * a[l] == x:
                        print('YES')
                        return
                    for m in range(i, n):
                        if a[i] * a[j] * a[k] * a[l] * a[m] > x:
                            break
                        if a[i] * a[j] * a[k] * a[l] * a[m] == x:
                            print('YES')
                            return
    print('NO')


def main():
    t = II()
    for _ in range(t):
        solve()


main()


