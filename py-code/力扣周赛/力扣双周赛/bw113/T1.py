# 8039. 使数组成为递增数组的最少右移次数
# 已解答
# 简单
# 相关企业
# 提示
# 给你一个长度为 n 下标从 0 开始的数组 nums ，数组中的元素为 互不相同 的正整数。请你返回让 nums 成为递增数组的 最少右移 次数，如果无法得到递增数组，返回 -1 。

# 一次 右移 指的是同时对所有下标进行操作，将下标为 i 的元素移动到下标 (i + 1) % n 处。


from typing import List


class Solution:
    def minimumRightShifts(self, nums: List[int]) -> int:
        index = -1
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                index = i
                break
        if index == -1: return 0
        # 检查index后面是否是有序的
        for i in range(index + 1, len(nums)):
            if nums[i] < nums[i - 1]: return -1
        # 检查末尾元素是否小于第一个元素
        if nums[-1] > nums[0]: return -1
        # 返回需要移动的次数
        return len(nums) - index
