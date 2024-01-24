

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
import pypyjit

sys.setrecursionlimit(10**6)
pypyjit.set_param("max_unroll_recursion=-1")



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

# https://atcoder.jp/contests/abc138/tasks/abc138_d

# 输入 n(2≤n≤2e5) q(1≤q≤2e5) 表示一个 n 个点的树（节点编号从 1 开始，根节点为 1）。
# 然后输入 n-1 条边（每行两个数）。
# 然后输入 q 个操作，每个操作输入 p(1≤p≤n) x(1≤x≤1e4)，表示把子树 p 内的所有节点值都加 x。（一开始所有节点值均为 0）
# 输出最终每个节点的节点值。（按节点编号从小到大输出）

'''
    只需要记录节点 p 的节点值增加了多少。
    然后从 1 开始 DFS 这棵树, DFS 的同时累加从 1 到当前节点 x 的这条路径上的节点值之和, 即为节点 x 的最终节点值。
    (类似 lazy 线段树的懒标记下传 push down)
    https://atcoder.jp/contests/abc138/submissions/45500929
'''


def solve():
    N, Q = MI()
    g = defaultdict(list)
    for _ in range(N - 1):
        u, v = MI()
        g[u].append(v)
        g[v].append(u)
    val = [0] * (N + 1)       # 记录节点p增加了多少
    for _ in range(Q):
        p, x = MI()
        val[p] += x
    # dfs对路径上的节点增量进行累加
    def dfs(u: int, fa: int) -> None:
        val[u] += val[fa]
        for v in g[u]:
            if v == fa: continue
            dfs(v, u)
    dfs(1, 0)
    print(*val[1:])
solve()




