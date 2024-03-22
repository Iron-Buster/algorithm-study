# 2808. 使循环数组所有元素相等的最少秒数
# 提示
# 中等
# 7
# 给你一个下标从 0 开始长度为 n 的数组 nums 。
#
# 每一秒，你可以对数组执行以下操作：
#
# 对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 nums[(i + 1) % n] 三者之一。
# 注意，所有元素会被同时替换。
#
# 请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。
from collections import defaultdict
from itertools import pairwise
from math import inf
from typing import List


class Solution:
    def minimumSeconds(self, nums: List[int]) -> int:
        # 最后的数字一定是数组中的数字 -> 枚举最后都变成哪个元素了
        # 考虑两个最近的相同数字 i j
        # 把 i 到 j 都变为nums[i]的 操作次数 = (j - i) // 2
        nums += nums                    # 破环成链
        pos = defaultdict(list)         # key:int, value:list
        for i, x in enumerate(nums):
            pos[x].append(i)
        ans = inf
        for idx in pos.values():
            mx = max((j - i) // 2 for i, j in pairwise(idx))
            ans = min(ans, mx)
        return ans


if __name__ == '__main__':
    print("Ok")