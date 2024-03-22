from collections import Counter
from functools import cache
from typing import List


# 740. 删除并获得点数
# 提示
# 中等
# 794
# 相关企业
# 给你一个整数数组 nums ，你可以对它进行一些操作。
#
# 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
#
# 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        @cache
        def dfs(i: int) -> int:
            return 0 if i < 0 else max(cnt[i] * i + dfs(i - 2), dfs(i - 1))
        return dfs(max(nums))


if __name__ == '__main__':
    res = Solution().deleteAndEarn([3, 4, 2])
    print(res)