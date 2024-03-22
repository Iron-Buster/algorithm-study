# 410. 分割数组的最大值
# 困难
# 830
# 相关企业
# 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
#
# 设计一个算法使得这 m 个子数组各自和的最大值最小。
from typing import List


# 最大值最小。模板1

class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def check(m: int) -> bool:
            cnt = s = 0
            for x in nums:
                if s + x > m:
                    cnt += 1
                    s = 0
                s += x
            return cnt >= k
        l, r = max(nums), sum(nums)
        while l < r:
            mid = l + r >> 1
            if check(mid):
                l = mid + 1
            else:
                r = mid
        return l




if __name__ == '__main__':
    res = Solution().splitArray([7, 2, 5, 10, 8], 2)
    print(res)