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

# http://101.43.147.120:8888/p/P1762
# P1762. 2024.03.28-腾讯音乐-第三题-塔子哥的区间好数

def solve():
    l, r = MI()

    # 数位dp模板，01 这个case 说明前导零是会影响答案的，需要isNum参数
    # cnt遇到一个偶数 + 1，奇数 - 1，最后判断cnt是否为0 并且是一个数字
    def f(x: int) -> int:
        s = str(x)
        n = len(s)

        @cache
        def dfs(i: int, cnt: int, isLimit: bool, isNum: bool) -> int:
            if i >= n:
                if isNum and cnt == 0:
                    return 1
                else:
                    return 0
            ans = 0
            if not isNum:
                ans += dfs(i + 1, cnt, False, False)
            up = int(s[i]) if isLimit else 9
            down = 0 if isNum else 1
            for d in range(down, up + 1):
                v = 1 if d % 2 == 0 else -1
                ans += dfs(i + 1, cnt + v, isLimit and d == up, True)
            return ans
        return dfs(0, 0, True, False)

    res = f(r) - f(l - 1)
    print(res)


def main():
    t = 1
    for _ in range(t):
        solve()


main()
