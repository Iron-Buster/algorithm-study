





from typing import List


'''
    单调栈 O(n) 解法
    [6, 0, 8, 2, 1, 5]
    [0, 1]
'''
class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        n = len(nums)
        stack = []
        # 1次单调栈求出递减序列 (定位可行的坡底)  [6 0]
        for i in range(n):
            if not stack or nums[stack[-1]] > nums[i]:
                stack.append(i)
        ans = 0
        # 倒序枚举坡顶
        for j in range(n - 1, -1, -1):
            while stack and nums[stack[-1]] <= nums[j]:
                i = stack.pop()
                ans = max(ans, j - i)   # 更新最大坡宽
        return ans