# 1020. 飞地的数量
# 提示
# 1615
# 222
# 第 130 场周赛
# Q4
# 相关企业
# 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
#
# 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
#
# 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
from typing import List


class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])

        def dfs(i: int, j: int) -> None:
            grid[i][j] = 0
            for x, y in (i + 1, j), (i, j + 1), (i - 1, j), (i, j - 1):
                if 0 <= x < m and 0 <= y < n and grid[x][y]:
                    dfs(x, y)

        for i in range(m):
            if grid[i][0] == 1:    dfs(i, 0)
            if grid[i][n - 1] == 1:  dfs(i, n - 1)

        for j in range(n):
            if grid[0][j] == 1:    dfs(0, j)
            if grid[m - 1][j] == 1:  dfs(m - 1, j)
        return sum(grid[i][j] for i in range(m) for j in range(n))


if __name__ == '__main__':
    grid = [[0,0,0,1],[0,1,1,0],[0,0,0,0]]
    ret = Solution().numEnclaves(grid)
    print(ret)