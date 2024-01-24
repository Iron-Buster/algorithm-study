from typing import List


# 1. 两数之和
# 提示
# 简单
# 17.4K
# 相关企业
# 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
#
# 你可以按任意顺序返回答案。

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = {}  # 创建一个哈希表
        for i, x in enumerate(nums):
            if target - x in mp:
                return [mp[target - x], i]
            mp[x] = i  # 保存nums[i] 和 i


if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9
    ret = Solution().twoSum(nums, target)
    print(ret)
