from typing import List

'''
https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-i/description/
'''

class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        ans = []
        j = cnt = 0
        pre = nums[0] - 1
        for i, x in enumerate(nums):
            if nums[i] == pre + 1:
                cnt += 1
            if i - j + 1 == k:
                if cnt == k:
                    ans.append(x)
                else:
                    ans.append(-1)
                if j + 1 < len(nums) and nums[j] + 1 == nums[j+1]:
                    cnt -= 1
                j += 1
            pre = nums[i]
        return ans

