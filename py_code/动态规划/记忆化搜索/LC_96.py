# 96. 不同的二叉搜索树
# 中等
# 2.3K
# 相关企业
# 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
from functools import cache


class Solution:
    def numTrees(self, n: int) -> int:
        @cache
        def dfs(n):
            if n == 0 or n == 1: return 1
            ans = 0
            for i in range(1, n + 1):
                ans += dfs(i - 1) * dfs(n - i)
            return ans
        return dfs(n)

if __name__ == '__main__':

    print("ok")
