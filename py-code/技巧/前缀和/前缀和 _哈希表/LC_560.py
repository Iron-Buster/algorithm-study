# 560. 和为 K 的子数组
# 提示
# 中等
# 2.1K
# 相关企业
# 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数
from collections import Counter
from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cnt = Counter()
        cnt[0] += 1
        res = s = 0
        for i, x in enumerate(nums):
            s += x
            if cnt[s - k] != 0:
                res += cnt[s - k]
            cnt[s] += 1
        return res
if __name__ == '__main__':

    print("Ok")