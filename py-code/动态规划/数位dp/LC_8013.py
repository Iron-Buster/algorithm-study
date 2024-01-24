# 8013. 范围中美丽整数的数目 显示英文描述
# 通过的用户数0
# 尝试过的用户数0
# 用户总通过次数0
# 用户总提交次数0
# 题目难度Hard
# 给你正整数 low ，high 和 k 。
#
# 如果一个数满足以下两个条件，那么它是 美丽的 ：
#
# 偶数数位的数目与奇数数位的数目相同。
# 这个整数可以被 k 整除。
# 请你返回范围 [low, high] 中美丽整数的数目。
from functools import cache


class Solution:

    def numberOfBeautifulIntegers(self, low: int, high: int, k: int) -> int:
        def calc(s: str) -> int:
            @cache
            def dfs(i: int, isLimit: bool, isNum: bool, diff: int, num: int) -> int:
                if i == len(s):
                    return 1 if isNum and num == 0 and diff == 0 else 0
                ans = 0
                if not isNum:
                    ans += dfs(i + 1, False, False, diff, num)
                up = int(s[i]) if isLimit else 9
                down = 0 if isNum else 1
                for d in range(down, up + 1):
                    # num 一直 mod k，最后如果num等于0 说明num能够被k整除
                    # cnt 变量遇到一个偶数数位 + 1，奇数数位 - 1，最后只需判断cnt是否为0
                    if d % 2 == 0:
                        ans += dfs(i + 1, isLimit and d == up, True, diff + 1, (num * 10 + d) % k)
                    else:
                        ans += dfs(i + 1, isLimit and d == up, True, diff - 1, (num * 10 + d) % k)
                return ans
            return dfs(0, True, False, 0, 0)
        return calc(str(high)) - calc(str(low - 1))

if __name__ == '__main__':
    res = Solution().numberOfBeautifulIntegers(10, 20, 3)