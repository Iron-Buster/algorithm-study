# https://leetcode.cn/problems/number-of-beautiful-pairs/?envType=daily-question&envId=2024-06-20

class Solution:
    def countBeautifulPairs(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            for j in range(i + 1, n):
                x = int(str(nums[i])[0])
                y = int(str(nums[j])[-1])
                if gcd(x, y) == 1:
                    ans += 1
        return ans
      
