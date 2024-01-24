# 275. H 指数 II
# 提示
# 中等
# 239
# 相关企业
# 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
#
# h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
#
# 请你设计并实现对数时间复杂度的算法解决此问题。
from typing import List

# 二分答案 模板2

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        def check(m: int) -> int:
            return sum(x >= m for x in citations) >= m
        l, r = 0, 1001
        while l < r:
            mid = l + r + 1 >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return l

if __name__ == '__main__':
    print("ok")