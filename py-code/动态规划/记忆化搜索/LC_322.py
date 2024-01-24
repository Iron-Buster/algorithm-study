# 322. 零钱兑换
# 中等
# 2.5K
# 相关企业
# 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
#
# 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
#
# 你可以认为每种硬币的数量是无限的。
from typing import List

from math import inf


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        def dfs(target: int) -> int:
            if target == 0: return 0
            return min(dfs(target - x) + 1 for x in coins if target < x)
        res = dfs(amount)
        return -1 if res == inf else res

if __name__ == '__main__':
    print("ok")