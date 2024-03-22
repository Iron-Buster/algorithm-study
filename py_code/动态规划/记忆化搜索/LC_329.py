from functools import cache
from typing import List


# 329. 矩阵中的最长递增路径
# 困难
# 777
# 相关企业
# 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
#
# 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。

class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        @cache
        def dfs(i: int, j: int, pre: int) -> int:
            if 0 <= i < m and 0 <= j < n:
                if matrix[i][j] <= pre:
                    return 0
                return max(dfs(i + 1, j, matrix[i][j]),
                           dfs(i, j + 1, matrix[i][j]),
                           dfs(i - 1, j, matrix[i][j]),
                           dfs(i, j - 1, matrix[i][j])) + 1
            else:
                return 0
        return max(dfs(i, j, -1) for i in range(m) for j in range(n))

if __name__ == '__main__':

    print("Ok")