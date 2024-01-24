# 875. 爱吃香蕉的珂珂
# 1766
# 532
# 第 94 场周赛
# Q3
# 相关企业
# 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
#
# 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
#
# 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
#
# 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）

# 最小速度 -> 最大值最小 模板1
from math import ceil
from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        def check(m: int) -> bool:
            return sum([ceil(x / m) for x in piles]) <= h  # 上取整
        l, r = 1, 1000000000
        while l < r:
            mid = l + r >> 1
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l

if __name__ == '__main__':
    print("ok")
