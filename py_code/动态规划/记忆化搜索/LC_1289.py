# 1289. 下降路径最小和 II
# 提示
# 1697
# 140
# 第 15 场双周赛
# Q4
# 相关企业
# 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
#
# 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
from functools import cache
from typing import List


class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        @cache
        def dfs(i: int, j: int) -> int:
            if i < 0 or i >= m or j < 0 or j >= n:
                return 0
            ans = 0x3f3f3f
            for nxj in range(n):
                if nxj != j:
                    ans = min(ans, dfs(i + 1, nxj) + grid[i][j])
            return ans
        res = min(dfs(0, j) for j in range(n))
        return grid[0][0] if res == 0x3f3f3f else res
if __name__ == '__main__':

    print("ok")