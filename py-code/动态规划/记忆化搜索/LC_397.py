# 397. 整数替换
# 中等
# 284
# 相关企业
# 给定一个正整数 n ，你可以做如下操作：
#
# 如果 n 是偶数，则用 n / 2替换 n 。
# 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
# 返回 n 变为 1 所需的 最小替换次数 。
from functools import cache


class Solution:
    def integerReplacement(self, n: int) -> int:
        @cache
        def dfs(v: int) -> int:
            if v == 1: return 0
            if v % 2 == 0:
                return 1 + dfs(v // 2)
            else:
                return 1 + min(dfs(v + 1), dfs(v - 1))
        return dfs(n)


if __name__ == '__main__':
    print("ok")