
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


# https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans = [-1, -1]
        if len(nums) == 0: return ans
        l, r = 0, len(nums) - 1
        # leftBound
        while l < r:
            mid = (l + r) >> 1
            if nums[mid] < target:
                l = mid + 1
            else:
                r = mid
        ans[0] = l if nums[l] == target else -1
        l, r = 0, len(nums) - 1
        # rightBound
        while l < r:
            mid = (l + r + 1) >> 1
            if nums[mid] > target:
                r = mid - 1
            else:
                l = mid
        ans[1] = l if nums[l] == target else -1
        return ans