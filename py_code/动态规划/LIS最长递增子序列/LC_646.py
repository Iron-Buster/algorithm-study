# 646. 最长数对链
# 中等
# 400
# 相关企业
# 给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
#
# 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。
#
# 找出并返回能够形成的 最长数对链的长度 。
#
# 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
from functools import cache
from typing import List


class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:
        pairs.sort()
        n = len(pairs)
        pairs.sort()
        dp = [0] * len(pairs)
        for i in range(0, n):
            cur = 0
            for j in range(0, i):
                if pairs[j][1] < pairs[i][0] and cur < dp[j]:
                    cur = max(cur, dp[j])
            dp[i] = cur + 1
        return max(dp)

        # 记忆化搜索
        # @cache
        # def dfs(i: int) -> int:
        #     if i == len(pairs):
        #         return 0
        #     ans = 0
        #     for j in range(i + 1, len(pairs)):
        #         if pairs[j][0] > pairs[i][1]:
        #             ans = max(ans, dfs(j))
        #     return ans
        # return max(dfs(i) for i in range(len(pairs)))


if __name__ == '__main__':
    paris = [[1,2], [2,3], [3,4]]
    res = Solution().findLongestChain(paris)
    print(res)