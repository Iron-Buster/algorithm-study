from functools import cache
from typing import List


# 377. 组合总和 Ⅳ
# 中等
# 842
# 相关企业
# 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
#
# 题目数据保证答案符合 32 位整数范围。

class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:

        @cache
        def dfs(target: int) -> int:
            if target < 0:  return 0
            if target == 0: return 1
            ans = 0
            for _, x in enumerate(nums):
                if target < x: continue
                ans += dfs(target - x)
            return ans

        return dfs(target)


if __name__ == '__main__':
    print("ok")
