# 1749. 任意子数组和的绝对值的最大值
# 提示
# 1542
# 46
# 第 45 场双周赛
# Q2
# company
# 亚马逊
# company
# 奥多比 Adobe
# company
# 推特 Twitter
# 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
#
# 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
#
# abs(x) 定义如下：
#
# 如果 x 是负整数，那么 abs(x) = -x 。
# 如果 x 是非负整数，那么 abs(x) = x 。
from typing import List


class Solution:
    def maxAbsoluteSum(self, nums: List[int]) -> int:
        v1 = v2 = nums[0]
        mx = mn = nums[0]
        for i in range(1, len(nums)):
            v1 = max(v1 + nums[i], nums[i])
            v2 = min(v2 + nums[i], nums[i])
            mx = max(mx, v1)
            mn = min(mn, v2)
        return max(mx, -mn)

if __name__ == '__main__':
    print("ok")
