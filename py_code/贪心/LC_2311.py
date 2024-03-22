# 2311. 小于等于 K 的最长二进制子序列
# 已解答
# 第 298 场周赛
# Q3
# 1840
# 相关标签
# 相关企业
# 提示
# 给你一个二进制字符串 s 和一个正整数 k 。

# 请你返回 s 的 最长 子序列，且该子序列对应的 二进制 数字小于等于 k 。

# 注意：

# 子序列可以有 前导 0 。
# 空字符串视为 0 。
# 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。

# 类似题目：atcode高位贪心
# https://atcoder.jp/contests/abc301/tasks/abc301_d



class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        ans = s.count('0')
        val = 0
        n = len(s)
        for i in range(n - 1, -1, -1):
            if s[i] == '1':
                tmp = 1 << (n - i - 1)
                if val + tmp > k: break
                ans += 1
                val += tmp
        return ans