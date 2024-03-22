# 2567. 修改两个元素的最小分数
# 已解答
# 第 98 场双周赛
# Q2
# 1609
# 相关标签
# 相关企业
# 提示
# 给你一个下标从 0 开始的整数数组 nums 。

# nums 的 最小 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最小值。
# nums的 最大 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最大值。
# nums 的分数是 最大 得分与 最小 得分的和。
# 我们的目标是最小化 nums 的分数。你 最多 可以修改 nums 中 2 个元素的值。

# 请你返回修改 nums 中 至多两个 元素的值后，可以得到的 最小分数 。

# |x| 表示 x 的绝对值。


from math import inf
from typing import List


class Solution:
    '''
        排序 + 分类讨论
        1.修改最大的两个数为 第3大的数字 最小得分=0, 最大得分=nums[n-3] - nums[0]
        2.修改最小的两个数为 第3小的数字 最小得分=0, 最大得分=nums[n-1] - nums[2]
        3.修改最小的这个数和最大的这个数 为第2大的数字 最小得分=0, 最大得分=nums[n-2] - nums[1]
    '''
    def minimizeSum(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        if n == 3: return 0
        ans = inf
        ans = min(ans, nums[n - 3] - nums[0])
        ans = min(ans, nums[n - 1] - nums[2])
        ans = min(ans, nums[n - 2] - nums[1])
        return ans
    