# 97. 交错字符串
# 中等
# 897
# 相关企业
# 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
#
# 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
#
# s = s1 + s2 + ... + sn
# t = t1 + t2 + ... + tm
# |n - m| <= 1
# 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
# 注意：a + b 意味着字符串 a 和 b 连接。
from functools import cache


class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3): return False
        @cache
        def dfs(i: int, j: int, k: int) -> bool:
            if k == len(s3): return True
            if i < len(s1) and j < len(s2) and s1[i] == s2[j] == s3[k]:
                return dfs(i + 1, j, k + 1) or dfs(i, j + 1, k + 1)
            if i < len(s1) and s1[i] == s3[k]:
                return dfs(i + 1, j, k + 1)
            if j < len(s2) and s2[j] == s3[k]:
                return dfs(i, j + 1, k + 1)
            return False
        return dfs(0, 0, 0)


if __name__ == '__main__':

    print("ok")