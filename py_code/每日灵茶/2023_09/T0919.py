
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


    # https://atcoder.jp/contests/abc301/tasks/abc301_d

    # 输入长度 ≤60 的字符串 s，只包含 '0'，'1' 和 '?'。
    # 输入 n(1≤n≤1e18)。
    # 你需要把 s 中的 ? 替换成 0 或 1，从而得到一个二进制数 x。
    # 问：不超过 n 的最大 x 是多少？
    # 以十进制形式输出这个最大值。
    # 如果不存在这样的 x，输出 -1。

    # 输入
    #     ?0?
    #     2
    # 输出 1

    # 输入
    #     101
    #     4
    # 输出 -1

    # 输入
    #     ?0?
    #     1000000000000000000
    # 输出 5

    #         【灵茶の试炼】往期题目&题解汇总
    # https://docs.qq.com/sheet/DWGFoRGVZRmxNaXFz



'''
    把 ? 都替换成 0, 如果此时 x > n, 则输出 -1。
    然后从左到右遍历每个 ?，如果把这个 ? 替换成 1, 右侧 ? 替换成 0 后，满足 x <= n，那么这个 ? 一定要替换成 1，否则这个 ? 一定要替换成 0。
    https://atcoder.jp/contests/abc301/submissions/45500660

'''

def solve():
    n = II()
    s = I()
    val = 0
    for i in range(len(s)):
        if s[i] == '1': 
            val = (val << 1) + 1
        else:
            val = val << 1
        if val > n:
            print(-1)
            return
        for i in range(len(s)):
            if s[i] == '?':
                tmp = val + (1 << (len(s) - i - 1))
                if tmp <= n:
                    val = tmp
        print(val) 

solve()




