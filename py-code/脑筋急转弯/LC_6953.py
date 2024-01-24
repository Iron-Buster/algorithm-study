from typing import List


# 6953. 判断是否能拆分数组
# 提示
# 中等
# 2
# 给你一个长度为 n 的数组 nums 和一个整数 m 。请你判断能否执行一系列操作，将数组拆分成 n 个 非空 数组。
#
# 在每一步操作中，你可以选择一个 长度至少为 2 的现有数组（之前步骤的结果） 并将其拆分成 2 个子数组，而得到的 每个 子数组，至少 需要满足以下条件之一：
#
# 子数组的长度为 1 ，或者
# 子数组元素之和 大于或等于  m 。
# 如果你可以将给定数组拆分成 n 个满足要求的数组，返回 true ；否则，返回 false 。
#
# 注意：子数组是数组中的一个连续非空元素序列。


class Solution:
    def canSplitArray(self, nums: List[int], m: int) -> bool:
        if len(nums) <= 2:
            return True
        for i in range(1, len(nums)):
            if nums[i] + nums[i - 1] >= m:
                return True
        return False


if __name__ == '__main__':
    print("ok")