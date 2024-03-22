# 643. 子数组最大平均数 I
# 已解答
# 简单
# 相关标签
# 相关企业
# 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。

# 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。

# 任何误差小于 10-5 的答案都将被视为正确答案。

from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        j = 0
        ans = -1e4
        sum = 0
        for i, x in enumerate(nums):
            sum += x
            if i - j + 1 > k:
                sum -= nums[j]
                j += 1
            if i - j + 1 == k:
                ans = max(ans, sum / k)
        return ans
