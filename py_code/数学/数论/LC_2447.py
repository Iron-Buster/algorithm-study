# 447. 最大公因数等于 K 的子数组数目
# 已解答
# 第 316 场周赛
# Q2
# 1603
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的子数组中元素的最大公因数等于 k 的子数组数目。

# 子数组 是数组中一个连续的非空序列。

# 数组的最大公因数 是能整除数组中所有元素的最大整数。



from math import gcd
from typing import List


class Solution:
    '''
        gcd(a,b)=gcd(a,a+b)=gcd(a,k⋅a+b)
        gcd(ka,kb)=k⋅gcd(a,b)。
        多个整数的最大公约数: gcd(a,b,c)=gcd(gcd(a,b),c)。
        若 gcd(a,b)=d 则 gcd(a/d,b/d)=1, 即 a/d=与 b/d=互素
        gcd(a+cb,b)=gcd(a,b)
    '''
    def subarrayGCD(self, nums: List[int], k: int) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            g = 0
            for j in range(i, n):
                g = gcd(g, nums[j])
                # 以i位置为子数组左边界 若最大公约数出现小于k的 提前退出循环
                if g < k: break     
                if g == k: ans += 1
        return ans
