from math import inf
from typing import List


# 209. 长度最小的子数组
# 中等
# 1.8K
# 相关企业
# 给定一个含有 n 个正整数的数组和一个正整数 target 。
#
# 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
# 并返回其长度。如果不存在符合条件的子数组，返回 0 。

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        i = j = sum = 0
        ans = inf
        for i, x in enumerate(nums):
            sum += x
            while sum >= target:
                ans = min(ans, i - j + 1)
                sum -= nums[j]
                j += 1
        return ans if ans < inf else 0


if __name__ == '__main__':

    print("ok")
