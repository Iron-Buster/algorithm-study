from collections import Counter
from typing import List


# 6900. 统计完全子数组的数目
# 提示
# 中等
# 4
# 相关企业
# 给你一个由 正 整数组成的数组 nums 。
#
# 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
#
# 子数组中 不同 元素的数目等于整个数组不同元素的数目。
# 返回数组中 完全子数组 的数目。
#
# 子数组 是数组中的一个连续非空序列

class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        m = len(set(nums))
        cnt = Counter()
        ans = left = 0
        for v in nums:
            ans += left
            cnt[v] += 1
            while len(cnt) == m:
                ans += 1
                x = nums[left]
                cnt[x] -= 1
                if cnt[x] == 0:
                    del cnt[x]
                left += 1
        return ans


if __name__ == '__main__':
    print("ok")