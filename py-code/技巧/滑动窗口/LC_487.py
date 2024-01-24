from typing import List


# 487. 最大连续1的个数 II
# 中等
# 137
# company
# 谷歌 Google
# company
# 亚马逊
# company
# Zoom
# 给定一个二进制数组 nums ，如果最多可以翻转一个 0 ，则返回数组中连续 1 的最大个数。
class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        # 反转元素求连续x的最大个数滑窗模板
        i = j = cnt1 = 0
        ans = 0
        while i < len(nums):
            cnt1 += nums[i]
            while i - j + 1 < cnt1 + 1:
                cnt1 -= nums[j]
                j -= 1
            ans = max(ans, i - j + 1)
        return ans





if __name__ == '__main__':

    print("Ok")