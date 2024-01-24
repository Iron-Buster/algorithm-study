# 115. 不同的子序列
# 困难
# 1.1K
# 相关企业
# 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。
#
# 题目数据保证答案符合 32 位带符号整数范围。
from functools import cache


class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        @cache
        def dfs(i: int, j: int) -> int:
            if j == len(t): return 1
            if i == len(s): return 0
            ans = 0
            if s[i] != t[j]:
                ans += dfs(i + 1, j)
            else:
                ans += dfs(i + 1, j + 1)
                ans += dfs(i + 1, j)
            return ans
        return dfs(0, 0)


if __name__ == '__main__':
    ans = Solution().numDistinct("babgbag", "bag")
    print(ans)