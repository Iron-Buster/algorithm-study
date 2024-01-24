
# LCP 06. 拿硬币
# 已解答
# 简单
# 相关标签
# 相关企业
# 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。



from typing import List


class Solution:
    def minCount(self, coins: List[int]) -> int:
        return sum((x + 1) >> 1 for x in coins)