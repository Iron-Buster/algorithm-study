from functools import cache


# 712. 两个字符串的最小ASCII删除和
# 提示
# 中等
# 334
# 相关企业
# 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和

class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        @cache
        def dfs(i: int, j: int) -> int:
            if i >= len(s1):
                return sum(ord(x) for x in s2[j:])
            if j >= len(s2):
                return sum(ord(x) for x in s1[i:])
            if s1[i] == s2[j]:
                return dfs(i+1, j+1)
            else:
                return min(dfs(i+1, j) + ord(s1[i]), dfs(i, j+1) + ord(s2[j]))

        return dfs(0, 0)


if __name__ == '__main__':
    print("ok")
