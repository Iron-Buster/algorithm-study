# 1137. 第 N 个泰波那契数
# 提示
# 1143
# 267
# 第 147 场周赛
# Q1
# 相关企业
# 泰波那契序列 Tn 定义如下：
#
# T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
#
# 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
from functools import cache


class Solution:
    def tribonacci(self, n: int) -> int:
        @cache
        def dfs(n: int) -> int:
            if n == 0: return 0
            if n == 1 or n == 2: return 1
            return dfs(n - 3) + dfs(n - 2) + dfs(n - 1)
        return dfs(n)


if __name__ == '__main__':

    print("ok")