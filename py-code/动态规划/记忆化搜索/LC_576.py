#
# 576. 出界的路径数
# 提示
# 中等
# 288
# 相关企业
# 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
#
# 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
from functools import cache

DIRS = [[1, 0], [-1, 0], [0, 1], [0, -1]]
class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        @cache
        def dfs(i: int, j: int, c: int) -> int:
            if i < 0 or i == m or j < 0 or j == n: return 1
            if c == 0: return 0
            ans = 0
            for v1, v2 in DIRS:
                ans += dfs(i + v1, j + v2, c - 1)
                ans %= 1000000007
            return ans
        return dfs(startRow, startColumn, maxMove)




if __name__ == '__main__':
    print("ok")