from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))


# https://leetcode.cn/problems/ugly-number-iii/description/


class Solution:
    '''
        设能被a整除的数字集合大小为A
        设能被b整除的数字集合大小为B
        设能被c整除的数字集合大小为C
        容斥原理 |AUBUC| = |A| + |B| + |C| - |A∩B| - |A∩C| - |B∩C| + |A∩B∩C|
    '''
    def nthUglyNumber(self, n: int, a: int, b: int, c: int) -> int:
        lcm_ab = lcm(a, b)
        lcm_ac = lcm(a, c)
        lcm_bc = lcm(b, c)
        lcm_abc = lcm(a, lcm_bc)

        l = 0
        r = 10 ** 27
        while l < r:
            mid = l + r >> 1
            cnt = mid // a + mid // b + mid // c - mid // lcm_ab - mid // lcm_ac - mid // lcm_bc + mid // lcm_abc
            if cnt >= n:
                r = mid
            else:
                l = mid + 1
        return l


