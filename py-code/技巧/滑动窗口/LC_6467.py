from collections import Counter
from typing import List


# 6467. 找出最长等值子数组
# 提示
# 中等
# 3
# 相关企业
# 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
#
# 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
#
# 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
#
# 子数组 是数组中一个连续且可能为空的元素序列。




class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        cnt = Counter()
        res = maxCnt = j = 0
        for i, x in enumerate(nums):
            cnt[x] += 1
            maxCnt = max(maxCnt, cnt[x])
            if i - j + 1 > maxCnt + k:
                cnt[j] -= 1
                j += 1
            res = max(res, maxCnt)
        return res


if __name__ == '__main__':
    print("ok")