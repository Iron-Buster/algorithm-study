# 5.
# 最长回文子串
# 提示
# 中等
# 6.7
# K
# 相关企业
# 给你一个字符串
# s，找到
# s
# 中最长的回文子串。
#
# 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。


class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        maxLen = 1
        ans = s
        for i in range(1, n):
            x = s[i]
            l = r = i
            while l >= 0 and s[l] == x:
                l -= 1
            while r < n and s[r] == x:
                r += 1
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            if r - l + 1 > maxLen:
                ans = s[l+1:r]
                maxLen = r - l + 1
        return  ans

if __name__ == '__main__':
    s = "babad"
    ret = Solution().longestPalindrome(s)
    print(ret)