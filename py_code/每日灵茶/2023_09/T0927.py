
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


# https://atcoder.jp/contests/abc098/tasks/arc098_b

# 输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]<2^20)。
# a 有多少个非空连续子数组，满足元素和等于元素异或和？

# 思考：改成子序列要怎么做？


'''
    这个等式意味着什么？
    意味着二进制加法不能有任何进位，否则等式右边一定大于左边。

    没有任何进位相当于什么？
    相当于子数组中的任意两个数，同一个比特位上不能都是 1, 也就是说, 任意两个数的按位与(AND)为 0。

    这题就是：
    2401. 最长优雅子数组  

    可以用滑动窗口做到 O(n)，请看题解：
    暴力枚举 / 双指针 

    https://atcoder.jp/contests/abc098/submissions/45104677
'''

def solve():
    n = II()
    a = LII()
    ans = j = mask = 0
    for i, x in enumerate(a):
        while mask & x:     # 有交集
            mask ^= a[j]    # 从mask集合去掉 a[j]
            j += 1
        mask |= x           # 把x并入mask中
        ans += i - j + 1
    print(ans)

def main():
    solve()
main()

