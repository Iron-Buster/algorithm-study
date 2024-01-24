# P1442. 2023.08.12-美团-第二题-仓储

import sys

def solve():
    input = lambda: sys.stdin.readline()
    write = lambda x:sys.stdout.write(str(x) + '\n')
    n = int(input())
    nums = list(map(int, input().split()))
    x, y = map(int, input().split())
    sum = s = 0
    for _, v in enumerate(nums):
        sum += v
    if x > y:
        y, x = x, y
    for i in range(x, y + 1):
        s += nums[i]
    ans = min(s, sum - s)
    write(ans)

if __name__ == '__main__':
    solve()