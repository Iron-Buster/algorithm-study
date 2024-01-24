# 518. 零钱兑换 II
# 中等
# 1.1K
# 相关企业
# 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
#
# 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
#
# 假设每一种面额的硬币有无限个。
#
# 题目数据保证结果符合 32 位带符号整数。
from functools import cache
from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        @cache
        def dfs(i: int, target: int) -> int:
            if i == len(coins):
                return 1 if target == 0 else 0
            if target == 0: return 1
            if target < 0: return 0
            ans = dfs(i, target - coins[i])
            ans += dfs(i + 1, target)
            return ans
        return dfs(0, amount)

if __name__ == '__main__':
    print("ok")