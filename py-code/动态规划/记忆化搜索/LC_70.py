from functools import cache


# 70. 爬楼梯
# 提示
# 简单
# 3.2K
# 相关企业
# 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
#
# 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

class Solution:
    def climbStairs(self, n: int) -> int:
        @cache
        def dfs(n: int) -> int:
            return n if n == 1 or n == 2 else dfs(n - 1) + dfs(n - 2)
        return dfs(n)

if __name__ == '__main__':
    print("Ok")