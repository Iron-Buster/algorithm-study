from functools import cache
from typing import List


# 902. 最大为 N 的数字组合
# 1990
# 257
# 第 101 场周赛
# Q3
# 相关企业
# 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
#
# 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。


class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        s = str(n)
        @cache
        def dfs(i: int, isLimit: bool, isNum: bool) -> int:
            if i == len(s):
                return 1 if isNum else 0
            ans = 0
            if not isNum:
                ans += dfs(i + 1, False, False)  # 选择不填
            up = s[i] if isLimit else '9'
            for d in digits:
                if d > up: break  # 超过限制
                ans += dfs(i + 1, isLimit and d == up, True)  # 填数字d
            return ans

        return dfs(0, True, False)


if __name__ == '__main__':
    # Solution().atMostNGivenDigitSet()
    print("ok")
