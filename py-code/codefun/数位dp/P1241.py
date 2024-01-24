# P1241. 2023.04.20-od-第三题-不含101的数


# 输入描述
# 输入为两个整数
# l 和 r ，表示区间的左右端点

# 输出描述
# 输出为一个整数，表示有多少个数的二进制表示中不含 101 子串。

import sys
from functools import cache


def solve():
    input = lambda: sys.stdin.readline()
    write = lambda x: sys.stdout.write(str(x) + '\n')

    l, r = list(map(int, input().split()))

    def calc(n: int) -> int:
        s = str(bin(n))[2:]
        @cache
        def dfs(i: int, isLimit: bool, v1: int, v2: int) -> int:
            if i == len(s):
                return 1
            ans = 0
            up = int(s[i]) if isLimit else 1
            for d in range(up + 1):
                if d == 1 and v1 == 1 and v2 == 0:
                    continue
                ans += dfs(i + 1, isLimit and d == up, v2, d)
            return ans
        return dfs(0, True, -1, -1)
    write(calc(r) - calc(l - 1))


if __name__ == '__main__':
    solve()
