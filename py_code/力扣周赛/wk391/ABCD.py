from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List
from sortedcontainers import SortedList

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))


class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x: int) -> int:
        s = str(x)
        SUM = 0
        for v in s:
            SUM += int(v)
        if x % SUM == 0:
            return SUM
        return -1



class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        cnt = numBottles
        v = 0
        while cnt >= numExchange:
            cnt = cnt - numExchange
            v += 1
            cnt += 1
            numExchange += 1
        return numBottles + v



class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        s = [1] * n
        for i in range(1, n):
            if nums[i] != nums[i-1]:
                s[i] += s[i-1]

        return sum(s)


class Solution:
    def minimumDistance(self, points: List[List[int]]) -> int:
        xs = SortedList()
        ys = SortedList()
        for x, y in points:
            xs.add(x + y)
            ys.add(y - x)
        ans = inf
        for x, y in points:
            x, y = x + y, y - x
            xs.remove(x)
            ys.remove(y)
            ans = min(ans, max(xs[-1] - xs[0], ys[-1] - ys[0]))
            xs.add(x)
            ys.add(y)
        return ans