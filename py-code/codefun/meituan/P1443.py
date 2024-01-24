# P1443. 2023.08.12-美团-第三题-分土地


import sys
from math import inf

'''
    二维前缀和
        枚举横切m 或者竖切n
'''
def solve():
    input = lambda: sys.stdin.readline()
    write = lambda x: sys.stdout.write(str(x) + '\n')
    m, n = map(int, input().split())
    pre = [[0 for _ in range(1010)] for _ in range(1010)]
    for i in range(1, m + 1):
        arr = [0] + list(map(int, input().split()))
        for j in range(1, n + 1):
            pre[i][j] = arr[j]
            pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1]
    ans = inf
    for i in range(1, m + 1):
        ans = min(ans, abs(pre[i][n] - (pre[m][n] - pre[i][n])))
    for j in range(1, n + 1):
        ans = min(ans, abs(pre[m][j] - (pre[m][n] - pre[m][j])))
    write(ans)


if __name__ == '__main__':
    solve()
