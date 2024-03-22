# 2344. 使数组可以被整除的最少删除次数
# 提示
# 1641
# 17
# 第 302 场周赛
# Q4
# 相关企业
# 给你两个正整数数组 nums 和 numsDivide 。你可以从 nums 中删除任意数目的元素。
#
# 请你返回使 nums 中 最小 元素可以整除 numsDivide 中所有元素的 最少 删除次数。如果无法得到这样的元素，返回 -1 。
#
# 如果 y % x == 0 ，那么我们说整数 x 整除 y 。
from math import gcd
from typing import List


# 求出numsDivide的最大公因数g
# 排序nums 枚举nums的元素 判断g能否整除x

class Solution:
    def minOperations(self, nums: List[int], numsDivide: List[int]) -> int:
        nums.sort()
        g = gcd(*numsDivide)
        res = 0
        for x in nums:
            if g % x == 0:
                break
            res += 1
        return -1 if res == len(nums) else res


if __name__ == '__main__':
    print("ok")