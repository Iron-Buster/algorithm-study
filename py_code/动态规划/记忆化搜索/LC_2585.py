from functools import cache
from typing import List


# 2585. 获得分数的方法数
# 提示
# 1910
# 28
# 第 335 场周赛
# Q4
# 相关企业
# 考试中有 n 种类型的题目。给你一个整数 target 和一个下标从 0 开始的二维整数数组 types ，其中 types[i] = [counti, marksi] 表示第 i 种类型的题目有 counti 道，每道题目对应 marksi 分。
#
# 返回你在考试中恰好得到 target 分的方法数。由于答案可能很大，结果需要对 109 +7 取余。
#
# 注意，同类型题目无法区分。
#
# 比如说，如果有 3 道同类型题目，那么解答第 1 和第 2 道题目与解答第 1 和第 3 道题目或者第 2 和第 3 道题目是相同的。


class Solution:
    def waysToReachTarget(self, target: int, types: List[List[int]]) -> int:
        @cache
        def dfs(idx: int, target: int) -> int:
            if target == 0:
                return 1
            if idx >= len(types) or target < 0:
                return 0
            ans, cnt = 0, types[idx][0]
            for i in range(cnt+1):
                ans += dfs(idx + 1, target - i * types[idx][1])
                ans %= 1000000007
            return ans
        return dfs(0, target)

if __name__ == '__main__':
    target = 6
    types = [[6,1],[3,2],[2,3]]
    ret = Solution().waysToReachTarget(target, types)
    print(ret)