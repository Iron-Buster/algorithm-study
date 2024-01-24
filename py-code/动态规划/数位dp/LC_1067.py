from functools import cache


# 1067. 范围内的数字计数
# 提示
# 2025
# 29
# 第 1 场双周赛
# Q4
# company
# 谷歌 Google
# company
# 亚马逊
# company
# eBay
# 给定一个在 0 到 9 之间的整数 d，和两个正整数 low 和 high 分别作为上下界。返回 d 在 low 和 high 之间的整数中出现的次数，包括边界 low 和 high。

class Solution:
    '''
        考虑前导零的影响，例如x=0 01 -> 1 并不包含数字0
    '''
    def digitsCount(self, x: int, low: int, high: int) -> int:
        def cacl(s: str):
            @cache
            def dfs(i: int, isLimit: bool, isNum: bool, xcnt: int) -> int:
                if i == len(s):
                    return xcnt if isNum else 0
                ans = 0
                if not isNum:
                    ans += dfs(i + 1, False, False, xcnt)
                down = 0 if isNum else 1
                up = int(s[i]) if isLimit else 9
                for d in range(down, up + 1):
                    ans += dfs(i + 1, isLimit and d == up, True, xcnt + (d == x))
                return ans
            return dfs(0, True, False, 0)
        return cacl(str(high)) - cacl(str(low - 1))

if __name__ == '__main__':
    ret = Solution().digitsCount(0, 1, 10)
    print(ret)