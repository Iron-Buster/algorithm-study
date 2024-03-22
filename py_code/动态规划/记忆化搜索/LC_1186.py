# 1186. 删除一次得到子数组最大和
# 提示
# 中等
# 285
# company
# 苹果 Apple
# company
# 优步 Uber
# company
# 彭博 Bloomberg
# 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
#
# 注意，删除一个元素后，子数组 不能为空。
from functools import cache
from math import inf
from typing import List


class Solution:
    def maximumSum(self, arr: List[int]) -> int:
        @cache
        def dfs(i: int, state: int) -> int:
            if i < 0:
                return -inf
            if state == 0:
                return max(dfs(i - 1, 0), 0) + arr[i]
            return max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0))
        return max(max(dfs(i, 0), dfs(i, 1)) for i in range(len(arr)))

if __name__ == '__main__':
    print("ok")
