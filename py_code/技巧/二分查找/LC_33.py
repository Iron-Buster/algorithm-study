from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from random import *
from typing import *
import random
import sys
import os
from io import BytesIO, IOBase
from copy import deepcopy
import threading

BUFSIZE = 4096
MOD = 10 ** 9 + 7
mod = 998244353
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))

'''
33. 搜索旋转排序数组
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
'''
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l = 0
        r = n - 1
        if nums[0] > nums[n//2]:
            if nums[n//2] >= target:
                l = n//2
            else:
                r = n//2-1
        else:
            if nums[n//2] > target:
                r = n//2 - 1
            else:
                l = n//2
        while l < r:
            mid = l + r + 1 >> 1
            if nums[mid] > target:
                r = mid - 1
            else:
                l = mid
        return l


if __name__ == '__main__':
    print(Solution().search([4, 5, 6, 7, 0, 1, 2], 0))