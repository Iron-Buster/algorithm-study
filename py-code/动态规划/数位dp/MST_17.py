from functools import cache


# 面试题 17.06. 2出现的次数
# 提示
# 困难
# 75
# 相关企业
# 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。

class Solution:
    def numberOf2sInRange(self, n: int) -> int:
        s = str(n)
        @cache
        def dfs(i: int, isLimit: bool, cnt2: int) -> int:
            if i == len(s):
                return cnt2
            ans = 0
            up = int(s[i]) if isLimit else 9
            for d in range(up + 1):
                ans += dfs(i + 1, isLimit and d == up, cnt2 + (d == 2))
            return ans
        return dfs(0, True, 0)

if __name__ == '__main__':

    print("ok")