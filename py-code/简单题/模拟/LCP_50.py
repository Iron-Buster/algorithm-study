# LCP 50. 宝石补给
# 已解答
# 简单
# 相关标签
# 相关企业
# 欢迎各位勇者来到力扣新手村，在开始试炼之前，请各位勇者先进行「宝石补给」。

# 每位勇者初始都拥有一些能量宝石， gem[i] 表示第 i 位勇者的宝石数量。现在这些勇者们进行了一系列的赠送，operations[j] = [x, y] 表示在第 j 次的赠送中 第 x 位勇者将自己一半的宝石（需向下取整）赠送给第 y 位勇者。

# 在完成所有的赠送后，请找到拥有最多宝石的勇者和拥有最少宝石的勇者，并返回他们二者的宝石数量之差。


from typing import List


class Solution:
    def giveGem(self, gem: List[int], operations: List[List[int]]) -> int:
        for (x, y) in operations:
            v = gem[x] >> 1
            gem[x] -= v
            gem[y] += v
        return max(gem) - min(gem)
    
