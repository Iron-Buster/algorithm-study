# 64. 最小路径和
# 中等
# 1.6K
# 相关企业
# 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
#
# 说明：每次只能向下或者向右移动一步。
from functools import cache
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        @cache
        def dfs(i: int, j: int) -> int:
            if i < 0 or j < 0: return 0x3f3f3f
            if i == 0 and j == 0: return grid[0][0]
            return grid[i][j] + min(dfs(i - 1, j), dfs(i, j - 1))
        return dfs(m - 1, n - 1)


if __name__ == '__main__':
    print("ok")