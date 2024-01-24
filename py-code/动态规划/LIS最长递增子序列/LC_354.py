# 354. 俄罗斯套娃信封问题
# 困难
# 932
# 相关企业
# 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
#
# 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
#
# 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
#
# 注意：不允许旋转信封。
from functools import cache
from typing import List

# TODO
class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: (x[0], -x[1]))
        @cache
        def dfs(i: int) -> int:
            if i == len(envelopes):
                return 0
            ans = 0
            for j in range(i + 1, len(envelopes)):
                if envelopes[i][0] < envelopes[j][0] and envelopes[i][1] < envelopes[j][1]:
                    ans = max(ans, dfs(j) + 1)
            return ans
        return max(dfs(i) + 1 for i in range(len(envelopes)))



if __name__ == '__main__':
    print("ok")