from functools import cache


# 6957. 统计范围内的步进数字数目
# 提示
# 困难
# 6
# 相关企业
# 给你两个正整数 low 和 high ，都用字符串表示，请你统计闭区间 [low, high] 内的 步进数字 数目。
#
# 如果一个整数相邻数位之间差的绝对值都 恰好 是 1 ，那么这个数字被称为 步进数字 。
#
# 请你返回一个整数，表示闭区间 [low, high] 之间步进数字的数目。
#
# 由于答案可能很大，请你将它对 109 + 7 取余 后返回。
#
# 注意：步进数字不能有前导 0 。



class Solution:
    def countSteppingNumbers(self, low: str, high: str) -> int:
        def calc(s: str) -> int:
            @cache
            def dfs(i: int, pre: int, isLimit: bool, isNum: bool) -> int:
                if i == len(s):
                    return 1 if isNum else 0
                ans = 0
                if not isNum:
                    ans += dfs(i + 1, pre, False, False)  # 当前位不填数字
                up = int(s[i]) if isLimit else 9
                down = 0 if isNum else 1                 # 去除前导零情况
                for d in range(down, up + 1):
                    if not isNum or abs(d - pre) == 1:   # 如果前面没填数字 或者当前数字与pre abs相差1
                        ans += dfs(i + 1, d, isLimit and d == up, True)
                return ans % 1000000007
            return dfs(0, 0, True, False)
        # low-1是将low也考虑进去
        return (calc(high) - calc(str(int(low) - 1))) % 1000000007


if __name__ == '__main__':
    ret = Solution().countSteppingNumbers("1", "11")
    print(ret)
