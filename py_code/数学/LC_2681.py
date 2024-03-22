from typing import List


# 2681. 英雄的力量
# 提示
# 2060
# 62
# 第 104 场双周赛
# Q4
# 相关企业
# 给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为：
#
# i0 ，i1 ，... ik 表示这组英雄在数组中的下标。那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])2 * min(nums[i0],nums[i1] ... nums[ik]) 。
# 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 109 + 7 取余。



class Solution:
    def sumOfPower(self, nums: List[int]) -> int:
        nums.sort()
        '''
        left 表示左侧元素对答案的贡献
            1 2 4
        4**3 + 4**2 * (a* 2**1 + b* 2**1)
        index = 0时:
            left = 0, ans = 0
            计算后 -> ans = (0 + 1) * 1**2   -> 1
                     left = (0 * 2 + 1)     -> 1
        index = 1时:
            left = 1, ans = 1
            计算后 -> ans = (1 + (1 + 2) * 2**2) -> 13
                      left = (1 * 2 + 2)        -> 4
        index = 2时:
            left = 4, ans = 13
            计算后 -> ans = (13 + (4 + 4) * 4**2) -> 141
                    left = (4 * 2 + 4)           -> 12            
        '''
        left = ans = 0
        for num in nums:
            ans = (ans + num**3 + (num**2 * left)) % 1000000007
            left = (left * 2 + num) % 1000000007
        return ans

if __name__ == '__main__':
    ret = Solution().sumOfPower([2, 1, 4])
    print(ret)