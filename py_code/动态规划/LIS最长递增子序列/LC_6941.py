from typing import List


# 6941. 将三个组排序
# 提示
# 中等
# 3
# 相关企业
# 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
#
# 从 0 到 n - 1 的数字被分为编号从 1 到 3 的三个组，数字 i 属于组 nums[i] 。注意，有的组可能是 空的 。
#
# 你可以执行以下操作任意次：
#
# 选择数字 x 并改变它的组。更正式的，你可以将 nums[x] 改为数字 1 到 3 中的任意一个。
# 你将按照以下过程构建一个新的数组 res ：
#
# 将每个组中的数字分别排序。
# 将组 1 ，2 和 3 中的元素 依次 连接以得到 res 。
# 如果得到的 res 是 非递减顺序的，那么我们称数组 nums 是 美丽数组 。
#
# 请你返回将 nums 变为 美丽数组 需要的最少步数。


class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        # 美丽数组的本质是最长递增子序列
        n = len(nums)
        dp = [1] * n
        for i, x in enumerate(nums):
            for j in range(i):
                if x >= nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return n - max(dp)

if __name__ == '__main__':
    print("ok")