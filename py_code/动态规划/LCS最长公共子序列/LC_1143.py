from functools import cache


# 1143. 最长公共子序列
# 提示
# 中等
# 1.4K
# 相关企业
# 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
#
# 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
#
# 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
# 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。


class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        @cache
        def dfs(i: int, j: int) -> int:
            if i == len(text1) or j == len(text2): return 0
            return dfs(i + 1, j + 1) + 1 if text1[i] == text2[j] else max(dfs(i + 1, j), dfs(i, j + 1))
        return dfs(0, 0)


if __name__ == '__main__':
    print("ok")