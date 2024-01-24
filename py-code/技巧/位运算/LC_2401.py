

# 2401. 最长优雅子数组
# 第 309 场周赛
# Q3
# 1750
# 相关标签
# 相关企业
# 提示
# 给你一个由 正 整数组成的数组 nums 。

# 如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。

# 返回 最长 的优雅子数组的长度。

# 子数组 是数组中的一个 连续 部分。

# 注意：长度为 1 的子数组始终视作优雅子数组。



# 每日灵茶 2023-09-27

from typing import List


class Solution:
    # https://atcoder.jp/contests/abc098/tasks/arc098_b 类似题目
    
    def longestNiceSubarray(self, nums: List[int]) -> int:
        ans = j = mask = 0
        for i, x in enumerate(nums):
            while mask & x:             # 有交集
                mask ^= nums[j]         # 将nums[j]从mask中移除
                j += 1
            mask |= x                   # 将x并上mask
            ans = max(ans, i - j + 1)   # 更新最长的ans
        return ans