# 926. 将字符串翻转到单调递增
# 已解答
# 第 107 场周赛
# Q2
# 1602
# 相关标签
# 相关企业
# 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。

# 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。

# 返回使 s 单调递增的最小翻转次数。



class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        n = len(s)
        dp = [[0 for _ in range(2)] for _ in range(n)]
        # dp[i][0] 表示以0结尾的单调递增字符串的最少翻转次数
        # dp[i][1] 表示以1结尾的单调递增字符串的最少翻转次数
        dp[0][0] = 0 if s[0] == '0' else 1
        dp[0][1] = 0 if s[0] == '1' else 1
        for i in range(1, n):
            if s[i] == '0':
                dp[i][0] = dp[i - 1][0]
                dp[i][1] = min(dp[i - 1][1] + 1, dp[i - 1][0] + 1)  # filp
            else:
                dp[i][0] = dp[i - 1][0] + 1                         # filp 
                dp[i][1] = min(dp[i - 1][1], dp[i - 1][0])          
        return min(dp[n - 1][0], dp[n - 1][1])