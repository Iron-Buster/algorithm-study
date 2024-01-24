from functools import cache


# 2376. 统计特殊整数
# 提示
# 困难
# 62
# 相关企业
# 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
#
# 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。


class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        s = str(n)
        @cache
        def dfs(i: int, mask: int, isLimit: bool, isNum: bool) -> int:
            if i == len(s):
                return 1 if isNum else 0
            ans = 0
            if not isNum:
                ans += dfs(i + 1, mask, False, False)  # 当前位不填数字
            low = 0 if isNum else 1  # 前导零情况
            up = int(s[i]) if isLimit else 9
            for d in range(low, up + 1):
                if mask >> d & 1 == 0:  # 集合mask中没有数字d
                    ans += dfs(i + 1, mask | (1 << d), isLimit and d == up, True)
            return ans
        return dfs(0, 0, True, False)


if __name__ == '__main__':
    print("ok")
