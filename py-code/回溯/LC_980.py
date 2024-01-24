# 980. 不同路径 III
# 1830
# 313
# 第 120 场周赛
# Q4
# company
# 奥多比 Adobe
# 在二维网格 grid 上，有 4 种类型的方格：
#
# 1 表示起始方格。且只有一个起始方格。
# 2 表示结束方格，且只有一个结束方格。
# 0 表示我们可以走过的空方格。
# -1 表示我们无法跨越的障碍。
# 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
#
# 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
from typing import List


class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        def dfs(i: int, j: int, cnt0: int) -> int:
            if i < 0 or i >= m or j < 0 or j >= n or grid[i][j] < 0:
                return 0                # 非法
            if grid[i][j] == 2:         # 终点
                return cnt0 == 0        # 到达终点必须经过所有的无障碍方格，不然返回0
            grid[i][j] = -1
            ans = dfs(i + 1, j, cnt0 - 1) + dfs(i - 1, j, cnt0 - 1) + \
                  dfs(i, j + 1, cnt0 - 1) + dfs(i, j - 1, cnt0 - 1)
            grid[i][j] = 0              # 恢复现场
            return ans

        cnt0 = sum(row.count(0) for row in grid)
        for i, row in enumerate(grid):
            for j, v in enumerate(row):
                if v == 1:
                    return dfs(i, j, cnt0)

if __name__ == '__main__':
    print("Ok")