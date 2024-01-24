from typing import List


# 1254. 统计封闭岛屿的数目
# 提示
# 中等
# 252
# 相关企业
# 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
#
# 请返回 封闭岛屿 的数目。


class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        num = 0
        m, n = len(grid), len(grid[0])

        def dfs(i: int, j: int) -> None:
            if i < 0 or i >= m or j < 0 or j >= n:
                nonlocal num
                num = 0
                return
            if grid[i][j]: return
            grid[i][j] = 1
            for x, y in (i + 1, j), (i, j + 1), (i - 1, j), (i, j - 1):
                dfs(x, y)

        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    num = 1
                    dfs(i, j)
                    ans += num
        return ans


if __name__ == '__main__':
    print("ok")