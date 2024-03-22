from functools import cache

# 233. 数字 1 的个数
# 提示
# 困难
# 525
# 相关企业
# 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

class Solution:
    def countDigitOne(self, n: int) -> int:
        s = str(n)
        @cache
        def dfs(i: int, isLimit: bool, cnt1: int) -> int:
            if i == len(s):
                return cnt1
            ans = 0
            up = int(s[i]) if isLimit else 9
            for d in range(up + 1):
                ans += dfs(i + 1, isLimit and d == up, cnt1 + (d == 1))
            return ans
        return dfs(0, True, 0)

if __name__ == '__main__':
    ret = Solution().countDigitOne(13)
    print(ret)

