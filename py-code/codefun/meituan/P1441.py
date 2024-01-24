# P1441. 2023.08.12-美团-第一题-排列查询
import sys


def solve():
    input = lambda: sys.stdin.readline()
    write = lambda x: sys.stdout.write(str(x) + '\n')
    n = int(input())
    nums = list(map(int, input().split()))
    x, y = map(int, input().split())
    for i, v in enumerate(nums):
        if v == x:
            if i - 1 >= 0 and nums[i - 1] == y:
                write("Yes")
                return
            if i + 1 <= n and nums[i + 1] == y:
                write("Yes")
                return
        elif v == y:
            if i - 1 >= 0 and nums[i - 1] == x:
                write("Yes")
                return
            if i + 1 <= n and nums[i + 1] == x:
                write("Yes")
                return
    print("No")

if __name__ == '__main__':
    solve()