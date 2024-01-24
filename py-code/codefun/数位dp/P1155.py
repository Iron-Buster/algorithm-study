# P1155. 2023.04.04-研发岗-第三题-k-好数
import sys
from functools import cache


def solve():
    input = lambda: sys.stdin.readline()
    write = lambda x: sys.stdout.write(str(x) + '\n')

    # 1001
    # 0011
    def calc(n: int, k: int) -> int:
        m = []
        while n:
            m.append(n % k)
            n //= k
        for i in range(len(m) - 1, -1, -1):
            if m[i] > 1:
                for j in range(i, -1, -1):
                    m[j] = 1
        m.reverse()
        @cache
        def dfs(i: int, isLimit: bool, isNum: bool) -> int:
            nonlocal m
            if i == len(m):
                return 1 if isNum else 0
            ans = 0
            if not isNum:
                ans += dfs(i + 1, False, False)
            up = m[i] if isLimit else 1
            down = 0 if isNum else 1
            for d in range(down, up + 1):
                ans += dfs(i + 1, isLimit and d == up, True)
            return ans
        return dfs(0, True, False)

    n = int(input())
    for _ in range(n):
        l, r, k = map(int, input().split())
        res = calc(r, k) - calc(l - 1, k)
        write(res)


if __name__ == '__main__':
    solve()
