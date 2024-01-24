# 2400. 恰好移动 k 步到达某一位置的方法数目
# 提示
# 1751
# 45
# 第 309 场周赛
# Q2
# 相关企业
# 给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置。
#
# 给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 109 + 7 取余 的结果。
#
# 如果所执行移动的顺序不完全相同，则认为两种方法不同。
#
# 注意：数轴包含负整数。
from functools import cache


class Solution:
    def numberOfWays(self, startPos: int, endPos: int, k: int) -> int:
        @cache
        def dfs(cur: int, k: int) -> int:
            if abs(cur - endPos) > k:
                return 0
            if cur == endPos and k == 0:
                return 1
            return (dfs(cur - 1, k - 1) + dfs(cur + 1, k - 1)) % 1000000007
        return dfs(startPos, k)





if __name__ == '__main__':
    ret = Solution().numberOfWays(1, 2, 3)
    print(ret)