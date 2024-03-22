from typing import List


# 11. 盛最多水的容器
# 提示
# 中等
# 4.4K
# 相关企业
# 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
#
# 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
#
# 返回容器可以储存的最大水量。
#
# 说明：你不能倾斜容器。


class Solution:
    def maxArea(self, height: List[int]) -> int:
        i = 0
        j = len(height) - 1
        ans = 0
        while i < j:
            w = j - i
            ans = max(ans, min(height[i], height[j]) * w)
            if height[i] > height[j]:
                j -= 1
            else:
                i += 1
        return ans

if __name__ == '__main__':
    height = [1,8,6,2,5,4,8,3,7]
    ret = Solution().maxArea(height)
    print(ret)