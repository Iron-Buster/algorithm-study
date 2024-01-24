from typing import List


# 15. 三数之和
# 提示
# 中等
# 6.2K
# 相关企业
# 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
#
# 你返回所有和为 0 且不重复的三元组。
#
# 注意：答案中不可以包含重复的三元组。


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        n = len(nums)
        # 固定i，枚举j, k = > nums[i] + nums[j] + nums[k] == 0
        # 转换为 nums[j] + nums[k] = -nums[i]
        for i in range(n - 2):
            x = nums[i]
            if i > 0 and x == nums[i - 1]:
                continue
            j = i + 1
            k = n - 1
            while j < k:
                s = x + nums[j] + nums[k]
                if s > 0:
                    k -= 1
                elif s < 0:
                    j += 1
                else:
                    ans.append([x, nums[j], nums[k]])
                    while j < k and nums[j] == nums[j - 1]:  # 跳过重复数字
                        j += 1
                    k -= 1
                    while k > j and nums[k] == nums[k + 1]:  # 跳过重复数字
                        k -= 1
        return ans

if __name__ == '__main__':
    nums = [-1,0,1,2,-1,-4]
    ret = Solution().threeSum(nums)
    print(ret)