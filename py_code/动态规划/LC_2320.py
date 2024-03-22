# 2320. 统计放置房子的方式数
# 已解答
# 第 299 场周赛
# Q2
# 1608
# 相关标签
# 相关企业
# 提示
# 一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。

# 现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 109 + 7 取余后再返回。

# 注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子


from functools import cache


MOD = 1000000007
class Solution:
    def countHousePlacements(self, n: int) -> int:
        # 计算一边的方案数v 根据乘法原理两边的放置房子的方案数=v*v
        @cache
        def dfs(i: int, state: int) -> int:
            if i <= 0: return 1
            ans = 0
            if state == 1:
                # 前面有房子当前不能放置
                ans += dfs(i - 1, 0)
            else:
                # 前面没有放房子 当前可选择 不放置 或者 放置
                ans += dfs(i - 1, 0)
                ans += dfs(i - 1, 1)
            ans %= MOD
            return ans
        v = dfs(n, 0)
        return v * v % MOD 