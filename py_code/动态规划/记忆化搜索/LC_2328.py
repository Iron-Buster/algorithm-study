# 2328. 网格图中递增路径的数目
# 提示
# 2001
# 34
# 第 300 场周赛
# Q4
# 相关企业
# 给你一个 m x n 的整数网格图 grid ，你可以从一个格子移动到 4 个方向相邻的任意一个格子。
#
# 请你返回在网格图中从 任意 格子出发，达到 任意 格子，且路径中的数字是 严格递增 的路径数目。由于答案可能会很大，请将结果对 109 + 7 取余 后返回。
#
# 如果两条路径中访问过的格子不是完全相同的，那么它们视为两条不同的路径。
from functools import cache
from typing import List


class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        @cache
        def dfs(i: int, j: int) -> int:
            ans = 1
            for x, y in (i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1):
                if 0 <= x < m and 0 <= y < n and grid[x][y] > grid[i][j]:
                    ans += dfs(x, y)
            return ans % 1000000007

        # 下面写法等价于
        # for i in range m:
        #    for j in range n:
        #        ans += dfs(i, j)
        return sum(dfs(i, j) for i in range(m) for j in range(n)) % 1000000007

if __name__ == '__main__':

    grid = [[1,1], [3,4]]
    ret = Solution().countPaths(grid)
    print(ret)