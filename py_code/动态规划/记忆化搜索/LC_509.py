from functools import cache


# 509 斐波那契数列

class Solution:
    def fib(self, n: int) -> int:
        @cache
        def dfs(v):
            return v if v <= 1 else dfs(v - 1) + dfs(v - 2)
        return dfs(n)



if __name__ == '__main__':
    print("ok")