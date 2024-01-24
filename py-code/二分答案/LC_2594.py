#
# 2594. 修车的最少时间
# 提示
# 1915
# 105
# 第 100 场双周赛
# Q4
# 相关企业
# 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。
# 能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
#
# 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
#
# 请你返回修理所有汽车 最少 需要多少时间。
#
# 注意：所有机械工可以同时修理汽车。
from math import isqrt
from typing import List


class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        # r * n^2 = m -> n = sqrt(m // x)
        def check(m: int, total: int) -> bool:
            for x in ranks:
                total -= isqrt(m // x)
                if total <= 0:
                    return True
            return total <= 0
        l, r = 1, 100000000000000
        while l < r:
            mid = l + r >> 1
            if check(mid, cars):
                r = mid
            else:
                l = mid + 1
        return l




if __name__ == '__main__':
    print("ok")