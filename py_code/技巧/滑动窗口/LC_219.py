# 219. 存在重复元素 II
# 简单
# 615
# 相关企业
# 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
# 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
# 如果存在，返回 true ；否则，返回 false 。
from collections import Counter
from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        cnt = Counter()
        i = j = 0
        for i, x in enumerate(nums):
            cnt[x] += 1
            while cnt[x] > 1:
                v = abs(i - j)
                if v <= k:
                    return True
                cnt[nums[j]] -= 1
                j += 1
        return False

if __name__ == '__main__':
    print("ok")