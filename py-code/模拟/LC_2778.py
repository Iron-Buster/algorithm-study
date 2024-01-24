# 2778. 特殊元素平方和
# 提示
# 简单
# 4
# 相关企业
# 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
#
# 对 nums 中的元素 nums[i] 而言，如果 n 能够被 i 整除，即 n % i == 0 ，则认为 num[i] 是一个 特殊元素 。
#
# 返回 nums 中所有 特殊元素 的 平方和 。

from typing import List


class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        n = len(nums)
        nums = [0] + nums
        return sum(nums[i] ** 2 for i in range(1, n + 1) if n % i == 0)


if __name__ == '__main__':
    print("ok")