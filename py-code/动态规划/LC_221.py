from typing import List


# 221. 最大正方形
# 中等
# 1.5K
# 相关企业
# 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        ans = 0
        m, n = len(matrix)+1, len(matrix[0])+1
        dp = [[0] * n for _ in range(m)]   # dp[m+1][n+1]大小的数组
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                    ans = max(ans, dp[i][j])
        return ans * ans


if __name__ == '__main__':
    print("ok")