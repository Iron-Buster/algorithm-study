# 03. 区域和检索 - 数组不可变
# 已解答
# 简单
# 相关标签
# 相关企业
# 给定一个整数数组  nums，处理以下类型的多个查询:

# 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
# 实现 NumArray 类：

# NumArray(int[] nums) 使用数组 nums 初始化对象
# int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )



from typing import List


class NumArray:
    def __init__(self, nums: List[int]):
        n = len(nums)
        self.preSum = [0] * (n + 1)
        for i in range(n):
            self.preSum[i + 1] = self.preSum[i] + nums[i]

    def sumRange(self, left: int, right: int) -> int:
        return self.preSum[right + 1] - self.preSum[left]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)
