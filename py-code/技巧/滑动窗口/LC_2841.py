# 2841. 几乎唯一子数组的最大和
# 提示
# 中等
# 1
# 相关企业
# 给你一个整数数组 nums 和两个正整数 m 和 k 。
#
# 请你返回 nums 中长度为 k 的 几乎唯一 子数组的 最大和 ，如果不存在几乎唯一子数组，请你返回 0 。
#
# 如果 nums 的一个子数组有至少 m 个互不相同的元素，我们称它是 几乎唯一 子数组。
#
# 子数组指的是一个数组中一段连续 非空 的元素序列。
from collections import Counter
from typing import List


class Solution:
    def maxSum(self, nums: List[int], m: int, k: int) -> int:
        cnt = Counter()
        res = sum = j = 0
        for i, x in enumerate(nums):
            cnt[x] += 1
            sum += x
            if i - j + 1 == k:
                if len(cnt) >= m:
                    res = max(res, sum)
                cnt[nums[j]] -= 1
                sum -= nums[j]
                if cnt[nums[j]] == 0:
                    del cnt[nums[j]]
                j += 1
        return res


if __name__ == '__main__':

    print("ok")