

'''
https://leetcode.cn/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-11-04
'''
from math import *


class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        # b^2 = c - a^2
        a = 0
        while a * a * 2 <= c:
            b = isqrt(c - a * a)
            if a * a + b * b == c:
                return True
            a += 1
        return False
