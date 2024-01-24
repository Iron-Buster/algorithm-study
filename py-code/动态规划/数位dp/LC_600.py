from functools import cache

# 600. 不含连续1的非负整数
# 困难
# 332
# 相关企业
# 给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。


class Solution:
    def findIntegers(self, n: int) -> int:
        s = str(bin(n))[2:]             # 将n转为二进制字符串
        # 对二进制字符串进行数位dp 规则是相邻的两位不能是1
        @cache
        def dfs(i: int, isLimit: bool, preOne: bool) -> int:
            if i == len(s):
                return 1
            ans = 0
            up = int(s[i]) if isLimit else 1
            for d in range(up + 1):
                if d == 1 and preOne: continue
                ans += dfs(i + 1, isLimit and d == up, d == 1)
            return ans
        return dfs(0, True, False)


if __name__ == '__main__':
    print("ok")