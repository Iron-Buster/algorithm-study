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

# 给您两个长度相等的字符串 a 和 b，其中只有字符 0 和/或 1；两个字符串都以字符 0 开始，以字符 1 结束。

# 您可以执行以下操作任意次数（可能为零）：

# 可以选择任意一个字符串，执行以下操作： 
#   选择下标l,r使得s[l]==s[r]，并令l<i<r的所有元素，都为s[l]，即s[i]=s[l],l<i<r
# 问，通过上述任意次操作，能否使原始的2个字符串，相等

'''
    枚举下标
    判断是否存在下标, 使得a[i] = b[i] = 0 
        (通过 l=0, r=i 可以使得前i个字符相等 并且后缀都相等 或者 a[i+1]=b[i+1]=1)
    判断是否存在下标, 使得a[i] = b[i] = 0 
        (通过 l=i, r=n 可以使得后n-i+1个字符相等 并且前缀都相等 或者 a[i-1]=b[i-1]=0)
'''
def solve():
    a = I()
    b = I()
    n = len(a)
    if n == 2:
        print('YES')
        return
    pre = 0
    suf = n - 1
    while pre < n and a[pre] == b[pre]:
        pre += 1
    pre -= 1
    while suf and a[suf] == b[suf]:
        suf -= 1
    suf += 1
    ok = False
    for i in range(1, n - 1):
        if a[i] != b[i]:
            continue
        if a[i] == '0' and (suf <= i + 1 or (a[i + 1] == b[i + 1] and a[i + 1] == '1')):
            ok = True
            break
        if a[i] == '1' and (pre >= i - 1 or (a[i - 1] == b[i - 1] and a[i - 1] == '0')):
            ok = True
            break
    if ok:
        print('YES')
    else:
        print('NO')
def main():
    t = II()
    for _ in range(t):
        solve()
main()

