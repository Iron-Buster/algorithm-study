from functools import cache


# 62. 不同路径
# 中等
# 1.9K
# 相关企业
# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
#
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
#
# 问总共有多少条不同的路径？

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        @cache
        def dfs(i: int, j: int) -> int:
            if i < 0 or i >= m or j < 0 or j >= n: return 0
            return 1 if i == 0 and j == 0 else dfs(i - 1, j) + dfs(i, j - 1)
        return dfs(m - 1, n - 1)

if __name__ == '__main__':
    print("Ok")