from functools import cache
from typing import List


# 494. 目标和
# 中等
# 1.7K
# company
# Facebook
# company
# 字节跳动
# company
# 谷歌 Google
# 给你一个非负整数数组 nums 和一个整数 target 。
#
# 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
#
# 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
# 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        @cache
        def dfs(i: int, v: int) -> int:
            if i == len(nums):
                return v == target
            return dfs(i + 1, v - nums[i]) + dfs(i + 1, v + nums[i])
        return dfs(0, 0)


if __name__ == '__main__':
    print("ok")