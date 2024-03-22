# 1746.
# 经过一次操作后的最大子数组和
# 提示
# 中等
# 27
# company
# 小红书
# 你有一个整数数组
# nums。你只能将一个元素
# nums[i]
# 替换为
# nums[i] * nums[i]。
#
# 返回替换后的最大子数组和。



from functools import cache
from math import inf
from typing import List
class Solution:
    def maxSumAfterOperation(self, nums: List[int]) -> int:
        @cache
        def dfs(i: int, state: int) -> int:
            if i < 0:
                return -inf
            if state == 0:
                return max(0, dfs(i - 1, 0)) + nums[i]
            return max(dfs(i - 1, 0) + nums[i] ** 2, dfs(i - 1, 1) + nums[i], nums[i] ** 2)
        return max(dfs(i, 1) for i in range(len(nums)))

if __name__ == '__main__':
    print("ok")