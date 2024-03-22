# 516. 最长回文子序列
# 中等
# 1.1K
# 相关企业
# 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
#
# 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
from functools import cache


class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        # 区间dp
        @cache
        def dfs(i: int, j: int) -> int:
            if i > j: return 0
            if i == j: return 1
            return dfs(i + 1, j - 1) + 2 if s[i] == s[j] else max(dfs(i + 1, j), dfs(i, j - 1))
        return dfs(0, len(s) - 1)


if __name__ == '__main__':
    print("Ok")
