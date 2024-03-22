from functools import cache


# 1012. 至少有 1 位重复的数字
# 提示
# 2230
# 262
# 第 128 场周赛
# Q4
# 相关企业
# 给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。


class Solution:
    def numDupDigitsAtMostN(self, n: int) -> int:
        # 正难则反 => 将问题转换为求[1,n]中数字数位没有重复数字的个数
        # 至少有 1 位重复的数字 = n - 没有重复数字的个数
        s = str(n)
        @cache
        def dfs(i: int, mask: int, isLimit: bool, isNum: int) -> int:
            if i == len(s):
                return 1 if isNum else 0
            ans = 0
            if not isNum:
                ans += dfs(i + 1, mask, False, False)
            up = int(s[i]) if isLimit else 9
            down = 0 if isNum else 1        # 前导零有影响 比如 010 => 10的数位并没有重复数字 而010有两个0
            for d in range(down, up + 1):
                if mask >> d & 1 == 0:      # mask集合中没有d
                    ans += dfs(i + 1, mask | (1 << d), isLimit and d == up, True)
            return ans
        return n - dfs(0, 0, True, False)

if __name__ == '__main__':
    ret = Solution().numDupDigitsAtMostN(20)
    print(ret)
